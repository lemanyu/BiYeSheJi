package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by gui on 2017/8/16.
 */

public class NewsAcitivity extends BaseActivity {
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.more)
    Button more;
    @BindView(R.id.web)
    WebView web;
    @BindView(R.id.tv)
    TextView tv;
    private String pic;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    public void initView() {
        String url = getIntent().getStringExtra("url");
        String text = getIntent().getStringExtra("text");
        pic = getIntent().getStringExtra("pic");
        if (!TextUtils.isEmpty(text)) {
            tv.setText(text);
        }
        //声明WebSettings子类
        WebSettings webSettings = web.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕
        webSettings.setUseWideViewPort(true);
        web.loadUrl(url);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

        more.setOnClickListener(this);
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.more:
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
        oks.setTitle(tv.getText().toString().trim());
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImageUrl(pic);//网络图片存在此张图片
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
}