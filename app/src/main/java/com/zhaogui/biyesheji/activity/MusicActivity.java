package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.bean.MusicBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 精选音乐界面
 */

public class MusicActivity extends AppCompatActivity {
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.rlv_music)
    RecyclerView rlvMusic;
    @BindView(R.id.srl_music)
    SmartRefreshLayout srlMusic;
    public int flag=1;
    private MusicBean musicBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        initData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initData() {
        dataFromNet(flag);
    }

    private void dataFromNet(final int flag) {
        OkGo.<String>get("http://route.showapi.com/255-1").params("showapi_appid","44333").
                params("showapi_sign","f8fc97c5902b48e0ac7552c799514016").params("type",31).
                params("page",flag).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                musicBean = new Gson().fromJson(response.body().toString(), MusicBean.class);
                rlvMusic.setLayoutManager(new LinearLayoutManager(MusicActivity.this));
                Myadapter myadapter = new Myadapter();
                rlvMusic.setAdapter(myadapter);
                myadapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                srlMusic.setOnRefreshListener(new OnRefreshListener() {
                    @Override
                    public void onRefresh(RefreshLayout refreshlayout) {
                        dataFromNet(1);
                        refreshlayout.finishRefresh(2000);
                    }
                });
                srlMusic.setOnLoadmoreListener(new OnLoadmoreListener() {
                    @Override
                    public void onLoadmore(RefreshLayout refreshlayout) {
                        final int[] a = {flag};
                        a[0]++;
                        dataFromNet(a[0]);
                        refreshlayout.finishLoadmore(2000);
                    }
                });
            }
        });
    }
   class  Myadapter extends BaseQuickAdapter<MusicBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean,BaseViewHolder>{

       public Myadapter() {
           super(R.layout.item_music, musicBean.getShowapi_res_body().getPagebean().getContentlist());
       }

       @Override
       protected void convert(BaseViewHolder holder, MusicBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean item) {
           holder.setText(R.id.tv_music_name,item.getName()).
                   setText(R.id.tv_music_title,item.getText()).
                   setText(R.id.tv_music_time,item.getCreate_time());
           Picasso.with(MusicActivity.this).load(item.getProfile_image()).into((ImageView) holder.getView(R.id.civ_music));
           JCVideoPlayerStandard jps_music = holder.getView(R.id.jps_music);
           jps_music.setUp(item.getVoice_uri(),JCVideoPlayer.SCREEN_LAYOUT_LIST,"");
           Picasso.with(MusicActivity.this).load(item.getImage3()).into(jps_music.thumbImageView);

       }
   }




    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
