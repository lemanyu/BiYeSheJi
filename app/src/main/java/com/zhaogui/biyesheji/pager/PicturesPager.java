package com.zhaogui.biyesheji.pager;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.squareup.picasso.Picasso;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseFragmentPager;
import com.zhaogui.biyesheji.bean.PicBean;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 趣图
 */

public class PicturesPager extends BaseFragmentPager {
    @BindView(R.id.rlv_pic)
    RecyclerView rlvPic;
    @BindView(R.id.efl_pic)
    EasyRefreshLayout eflPic;
    Unbinder unbinder;
    private int flag=1;
    private PicBean picBean;
    private PicBean flagpb;
    private MyAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.pager_pictuer, null);
        return view;
    }

    @Override
    protected void initData() {
        dataFromNet(flag);
        eflPic.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        flag++;
                        dataFromNet(flag);
                        eflPic.loadMoreComplete(new EasyRefreshLayout.Event() {
                            @Override
                            public void complete() {
                                if(flagpb==picBean){
                                    return;
                                }else{
                                    adapter.getData().addAll(0,picBean.getResult().getData());
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }, 500);
                    }
                },1000);
            }

            @Override
            public void onRefreshing() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dataFromNet(1);
                        if(flagpb==picBean){
                            Toast.makeText(mActivity, "当前没有最新数据", Toast.LENGTH_SHORT).show();
                            eflPic.refreshComplete();
                        }else{
                            Toast.makeText(mActivity, "已经加载更多数据", Toast.LENGTH_SHORT).show();
                            adapter.setNewData(picBean.getResult().getData());
                            eflPic.refreshComplete();
                        }
                    }
                },2000);

            }
        });
    }

    private void dataFromNet(int flag) {
        OkGo.<String>get("http://japi.juhe.cn/joke/img/text.from").
                params("key","7a0e449f9f62f63124d78812a6f917e0").
                params("page",flag).params("pagesize",20).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                picBean = new Gson().fromJson(response.body().toString(), PicBean.class);
                flagpb = picBean;
                adapter = new MyAdapter();
                rlvPic.setLayoutManager(new LinearLayoutManager(mActivity));
                rlvPic.setAdapter(adapter);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
            }

            @Override
            public void onCacheSuccess(Response<String> response) {
                picBean = new Gson().fromJson(response.body().toString(), PicBean.class);
                flagpb = picBean;
                adapter = new MyAdapter();
                rlvPic.setLayoutManager(new LinearLayoutManager(mActivity));
                rlvPic.setAdapter(adapter);
                adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View view) {

    }

    class MyAdapter extends BaseQuickAdapter<PicBean.ResultBean.DataBean, BaseViewHolder> {

        public MyAdapter() {
            super(R.layout.item_pic,picBean.getResult().getData());
        }

        @Override
        protected void convert(BaseViewHolder holder, PicBean.ResultBean.DataBean item) {
            holder.setText(R.id.tv_pic_time,item.getUpdatetime()).
                    setText(R.id.tv_pic_title,item.getContent());
            Picasso.with(mActivity).load(item.getUrl()).into((ImageView) holder.getView(R.id.giv));
        }
    }
}
