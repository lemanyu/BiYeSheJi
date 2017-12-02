package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 在线购票页面
 */

public class OnlinePurchaseActivity extends BaseActivity {
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.online)
    Button online;
    @BindView(R.id.wv_online)
    WebView wvOnline;
    private String url;

    @Override
    public int getLayoutId() {
        return R.layout.activity_online;
    }

    @Override
    public void initView() {
        url = getIntent().getStringExtra("url");
        if(TextUtils.isEmpty(url)){
            return;
        }

    }

    @Override
    public void initData() {
            dataFromNet();
    }

    private void dataFromNet() {
        WebSettings settings = wvOnline.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        wvOnline.loadUrl(url);
//        wvOnline.setWebViewClient(new WebViewClient(){
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
        wvOnline.setWebViewClient(new WebViewClient());
        wvOnline.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void initListener() {
         online.setOnClickListener(this);
    }

    @Override
    public void processClick(View v) {
                switch (v.getId()){
                    case R.id.online:
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
        oks.setTitle("在线购票");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
       // oks.setImageUrl(pic);//网络图片存在此张图片
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
