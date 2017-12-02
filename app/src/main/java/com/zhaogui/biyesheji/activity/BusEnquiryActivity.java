package com.zhaogui.biyesheji.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 汽车站查询
 */

public class BusEnquiryActivity extends BaseActivity {
    @BindView(R.id.back)
    Button back;

    @BindView(R.id.bt_enquiry)
    Button btEnquiry;
    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.et_star_addr)
    EditText etStarAddr;
    @BindView(R.id.et_end_addr)
    EditText etEndAddr;

    @Override
    public int getLayoutId() {

        return R.layout.activity_enquiry;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        btEnquiry.setOnClickListener(this);
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.bt_enquiry:
                Intent intent = new Intent(BusEnquiryActivity.this, BusStationActivity.class);
                intent.putExtra("city", etCity.getText().toString().trim());
                intent.putExtra("start", etStarAddr.getText().toString().trim());
                intent.putExtra("end", etEndAddr.getText().toString().trim());
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
