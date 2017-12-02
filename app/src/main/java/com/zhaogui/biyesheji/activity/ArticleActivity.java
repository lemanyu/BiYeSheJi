package com.zhaogui.biyesheji.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 微信文章页面
 */

public class ArticleActivity extends BaseActivity {
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.bt_article)
    Button btArticle;
    @BindView(R.id.web_article)
    WebView webArticle;
    @BindView(R.id.tv_article)
    TextView tvArticle;
    private String url;
    private String pic;

    @Override
    public int getLayoutId() {
        return R.layout.activity_article;
    }

    @Override
    public void initView() {
        url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        pic = getIntent().getStringExtra("pic");
        tvArticle.setText("来自于："+title);

    }

    @Override
    public void initData() {
        WebSettings settings = webArticle.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        webArticle.setWebChromeClient(new WebChromeClient());
        webArticle.loadUrl(url);
        webArticle.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webArticle.loadUrl(request.getUrl() + "");
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    public void initListener() {
           btArticle.setOnClickListener(this);
    }

    @Override
    public void processClick(View v) {
           switch (v.getId()){
               case R.id.bt_article:
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
        oks.setTitle(tvArticle.getText().toString());
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
