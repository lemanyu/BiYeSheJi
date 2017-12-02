package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.HistoryBean;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 历史详情页面
 */

public class HistoryActivity extends BaseActivity {
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.bt_history)
    Button btHistory;
    @BindView(R.id.iv_history)
    ImageView ivHistory;
    @BindView(R.id.tv_history_data)
    TextView tvHistoryData;
    @BindView(R.id.tv_history_lunar)
    TextView tvHistoryLunar;
    @BindView(R.id.tv_history_year)
    TextView tvHistoryYear;
    @BindView(R.id.tv_history_month)
    TextView tvHistoryMonth;
    @BindView(R.id.tv_history_day)
    TextView tvHistoryDay;
    private int id;
    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    public void initView() {
        id = getIntent().getIntExtra("id",0);
        title = getIntent().getStringExtra("title");
        tvHistory.setText(title);
    }

    @Override
    public void initData() {
        OkGo.<String>get("http://apis.haoservice.com/lifeservice/toh/tohdet").
                params("id",id).params("key","d6efc7c5164e4110a9d1acb55e6831f7").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Log.e("zhaoguiaaaaaaaaaa",response.body().toString());
//                HistoryBean bean = new Gson().fromJson(response.body().toString(), HistoryBean.class);

                HistoryBean bean= new Gson().fromJson(response.body().toString(), HistoryBean.class);
                if(bean.getResult().getPic()!=null&&!bean.getResult().getPic().isEmpty()){
                    ivHistory.setVisibility(View.VISIBLE);
                    Picasso.with(HistoryActivity.this).load(bean.getResult().getPic()).into(ivHistory);
                }else{
                    ivHistory.setVisibility(View.GONE);
                }
                tvHistoryData.setText(bean.getResult().getDes());
                tvHistoryLunar.setText(bean.getResult().getLunar());
                tvHistoryYear.setText(bean.getResult().getYear()+"年");
                tvHistoryMonth.setText(bean.getResult().getMonth()+"月");
                tvHistoryDay.setText(bean.getResult().getDay()+"日");

            }
        });
    }

    @Override
    public void initListener() {
             btHistory.setOnClickListener(this);
    }

    @Override
    public void processClick(View v) {
           switch (v.getId()){
               case R.id.bt_history:
                   //分享
                   showShare();
                   break;
           }
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不     调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(tvHistory.getText().toString().trim());
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        if(bean.getResult().getPic()!=null&&!bean.getResult().getPic().isEmpty()){
//            oks.setImageUrl(bean.get(0).getResult().getPic());//网络图片存在此张图片
//        }
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
