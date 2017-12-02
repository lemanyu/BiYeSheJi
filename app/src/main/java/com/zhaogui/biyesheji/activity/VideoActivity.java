package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
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
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.VideoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 精彩视频界面
 */

public class VideoActivity extends AppCompatActivity {
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.rlv_video)
    RecyclerView rlvVideo;
    @BindView(R.id.srl_video)
    SmartRefreshLayout srlVideo;
    public int flag=1;
    private VideoBean videoBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initData();
    }

    public int getLayoutId() {

        return R.layout.activity_video;
    }

    public void initData() {
            dataFromNet(flag);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 finish();
             }
         });

    }

    private void dataFromNet(final int flag) {
        OkGo.<String>get("http://route.showapi.com/255-1").params("showapi_appid","44333").
                params("showapi_sign","f8fc97c5902b48e0ac7552c799514016").params("type",41).
                params("page",flag).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                videoBean = new Gson().fromJson(response.body().toString(), VideoBean.class);
                rlvVideo.setLayoutManager(new LinearLayoutManager(VideoActivity.this));
                Myadapter myadapter = new Myadapter();
                rlvVideo.setAdapter(myadapter);
                myadapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                srlVideo.setOnRefreshListener(new OnRefreshListener() {
                    @Override
                    public void onRefresh(RefreshLayout refreshlayout) {
                        dataFromNet(1);
                        refreshlayout.finishRefresh(2000);
                    }
                });
                srlVideo.setOnLoadmoreListener(new OnLoadmoreListener() {
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
             class  Myadapter extends BaseQuickAdapter<VideoBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean,BaseViewHolder>{

                 public Myadapter() {
                     super(R.layout.item_video, videoBean.getShowapi_res_body().getPagebean().getContentlist());
                 }

                 @Override
                 protected void convert(BaseViewHolder holder, VideoBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean item) {
                     holder.setText(R.id.tv_video_name,item.getName()).setText(R.id.tv_video_title,item.getText()).
                             setText(R.id.tv_video_time,item.getCreate_time());
                     Picasso.with(VideoActivity.this).load(item.getProfile_image()).into((ImageView) holder.getView(R.id.civ_video));
                     JCVideoPlayerStandard jps_video = holder.getView(R.id.jps_video);
                     jps_video.setUp(item.getVideo_uri(),JCVideoPlayer.SCREEN_LAYOUT_LIST,"");
                     jps_video.thumbImageView.setImageResource(R.mipmap.ic_launcher);
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
