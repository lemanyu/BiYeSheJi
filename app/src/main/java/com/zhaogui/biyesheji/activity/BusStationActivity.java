package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.TicketBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gui on 2017/8/20.
 */

public class BusStationActivity extends BaseActivity {

    @BindView(R.id.back)
    Button back;
    @BindView(R.id.rlv_ticket)
    RecyclerView rlvTicket;
    private String city;
    private String start;
    private String end;
    private TicketBean ticketBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ticket;
    }

    @Override
    public void initView() {
        city = getIntent().getStringExtra("city");
        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
    }

    @Override
    public void initData() {
        OkGo.<String>get("http://route.showapi.com/844-3").params("showapi_appid", "44333").
                params("showapi_sign", "f8fc97c5902b48e0ac7552c799514016").
                params("city", city).params("start_addr", start).params("end_addr", end).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                ticketBean = new Gson().fromJson(response.body().toString(), TicketBean.class);
                rlvTicket.setLayoutManager(new LinearLayoutManager(BusStationActivity.this));
                Myadapter myadapter = new Myadapter();
                rlvTicket.setAdapter(myadapter);
                myadapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class Myadapter extends BaseQuickAdapter<TicketBean.ShowapiResBodyBean.BusListBean, BaseViewHolder> {


        public Myadapter() {
            super(R.layout.item_ticket,ticketBean.getShowapi_res_body().getBusList());
        }

        @Override
        protected void convert(BaseViewHolder holder, TicketBean.ShowapiResBodyBean.BusListBean item) {
            for (int i = 0; i < item.getSegList().size(); i++) {
                holder.setText(R.id.tv_bus_title,item.getSegList().get(i).getLine_name()).setText(R.id.tv_bus_start,item.getSegList().get(i).getStart_stat())
                        .setText(R.id.tv_bus_end,item.getSegList().get(i).getEnd_stat()).setText(R.id.tv_bus_station,item.getSegList().get(i).getStats());
            }
        }
    }

    @Override
    public void processClick(View v) {

    }
}
