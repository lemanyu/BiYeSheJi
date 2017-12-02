package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.MoreBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 景点详情列表
 */

public class MoreDetailsActivity extends BaseActivity {
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.rlv_more)
    RecyclerView rlvMore;
    @BindView(R.id.tv_more_title)
    TextView tvMoreTitle;
    private String sid;
    private MoreBean moreBean;

    @Override
    public int getLayoutId() {

        return R.layout.activity_more;
    }

    @Override
    public void initView() {
        sid = getIntent().getStringExtra("sid");
        String title = getIntent().getStringExtra("title");
        tvMoreTitle.setText(title);
    }

    @Override
    public void initData() {
        OkGo.<String>get("http://apis.haoservice.com/lifeservice/travel/GetScenery")
                .params("sid", sid).params("key", "b836e20773d5418a9f8d656039cf6c34").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                moreBean = new Gson().fromJson(response.body().toString(), MoreBean.class);
                Myadapter adapter = new Myadapter();
                rlvMore.setLayoutManager(new LinearLayoutManager(MoreDetailsActivity.this));
                rlvMore.setAdapter(adapter);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
            }
        });
    }
    class Myadapter extends BaseQuickAdapter<MoreBean.ResultBean, BaseViewHolder> {

        public Myadapter() {
            super(R.layout.item_more, moreBean.getResult());
        }

        @Override
        protected void convert(BaseViewHolder holder, MoreBean.ResultBean item) {
            holder.setText(R.id.tv_more_referra,item.getReferral());
            if(item.getImg()!=null&&!item.getImg().isEmpty()){
                Picasso.with(MoreDetailsActivity.this).load(item.getImg()).into((ImageView) holder.getView(R.id.iv_more));
            }else{
                Picasso.with(MoreDetailsActivity.this).load(R.drawable.ic_wrong).into((ImageView) holder.getView(R.id.iv_more));
            }
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    public void processClick(View v) {

    }


}
