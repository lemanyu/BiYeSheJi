package com.zhaogui.biyesheji.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhaogui.biyesheji.R;
import com.zhaogui.biyesheji.base.BaseActivity;
import com.zhaogui.biyesheji.bean.HoroscopeBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 星座运势
 */

public class HoroscopeActivity extends BaseActivity {
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.aiqingyunshi1)
    TextView aiqingyunshi1;
    @BindView(R.id.caifuyunshi1)
    TextView caifuyunshi1;
    @BindView(R.id.gongzuoyunshi1)
    TextView gongzuoyunshi1;
    @BindView(R.id.aiqing1)
    TextView aiqing1;
    @BindView(R.id.caifu1)
    TextView caifu1;
    @BindView(R.id.gongzuo1)
    TextView gongzuo1;
    @BindView(R.id.shijian1)
    TextView shijian1;
    @BindView(R.id.shuzi1)
    TextView shuzi1;
    @BindView(R.id.yanse1)
    TextView yanse1;
    @BindView(R.id.day_general)
    TextView dayGeneral;
    @BindView(R.id.aiqingyunshi2)
    TextView aiqingyunshi2;
    @BindView(R.id.caifuyunshi2)
    TextView caifuyunshi2;
    @BindView(R.id.gongzuoyunshi2)
    TextView gongzuoyunshi2;
    @BindView(R.id.aiqing2)
    TextView aiqing2;
    @BindView(R.id.caifu2)
    TextView caifu2;
    @BindView(R.id.gongzuo2)
    TextView gongzuo2;
    @BindView(R.id.shijian2)
    TextView shijian2;
    @BindView(R.id.shuzi2)
    TextView shuzi2;
    @BindView(R.id.yanse2)
    TextView yanse2;
    @BindView(R.id.tommor_general)
    TextView tommorGeneral;
    @BindView(R.id.aiqingyunshi3)
    TextView aiqingyunshi3;
    @BindView(R.id.caifuyunshi3)
    TextView caifuyunshi3;
    @BindView(R.id.gongzuoyunshi3)
    TextView gongzuoyunshi3;
    @BindView(R.id.aiqing3)
    TextView aiqing3;
    @BindView(R.id.caifu3)
    TextView caifu3;
    @BindView(R.id.gongzuo3)
    TextView gongzuo3;
    @BindView(R.id.shijian3)
    TextView shijian3;
    @BindView(R.id.shuzi3)
    TextView shuzi3;
    @BindView(R.id.yanse3)
    TextView yanse3;
    @BindView(R.id.week_general)
    TextView weekGeneral;
    @BindView(R.id.guiren)
    TextView guiren;
    @BindView(R.id.xiaoren)
    TextView xiaoren;
    @BindView(R.id.aiqingyunshi4)
    TextView aiqingyunshi4;
    @BindView(R.id.caifuyunshi4)
    TextView caifuyunshi4;
    @BindView(R.id.gongzuoyunshi4)
    TextView gongzuoyunshi4;
    @BindView(R.id.aiqing4)
    TextView aiqing4;
    @BindView(R.id.caifu4)
    TextView caifu4;
    @BindView(R.id.gongzuo4)
    TextView gongzuo4;
    @BindView(R.id.shijian4)
    TextView shijian4;
    @BindView(R.id.shuzi4)
    TextView shuzi4;
    @BindView(R.id.yanse4)
    TextView yanse4;
    @BindView(R.id.month_general)
    TextView monthGeneral;
    @BindView(R.id.yuanfen)
    TextView yuanfen;
    private String type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_horoscope;
    }

    @Override
    public void initView() {
        type = getIntent().getStringExtra("type");
    }

    @Override
    public void initData() {
        OkGo.<String>get("http://route.showapi.com/872-1").
                params("showapi_appid", "44333").params("showapi_sign", "f8fc97c5902b48e0ac7552c799514016").
                params("star", type).params("needTomorrow","1").params("needWeek","1").params("needMonth","1").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                HoroscopeBean horoscopeBean = new Gson().fromJson(response.body().toString(), HoroscopeBean.class);
                datafromNet(horoscopeBean.getShowapi_res_body());
            }
        });
    }

    private void datafromNet(HoroscopeBean.ShowapiResBodyBean horoscopeBean) {
        aiqingyunshi1.setText(horoscopeBean.getDay().getLove_txt());
        caifuyunshi1.setText(horoscopeBean.getDay().getMoney_txt());
        gongzuoyunshi1.setText(horoscopeBean.getDay().getWork_txt());
        aiqing1.setText("爱情指数：" + horoscopeBean.getDay().getLove_star());
        caifu1.setText("财富指数：" + horoscopeBean.getDay().getMoney_star());
        gongzuo1.setText("工作指数：" + horoscopeBean.getDay().getWork_star());
        shijian1.setText("幸运时间：" + horoscopeBean.getDay().getLucky_time());
        shuzi1.setText("幸运数字：" + horoscopeBean.getDay().getLucky_num());
        yanse1.setText("幸运颜色：" + horoscopeBean.getDay().getLucky_color());
        dayGeneral.setText("运势简评：" + horoscopeBean.getDay().getGeneral_txt());
        aiqingyunshi2.setText(horoscopeBean.getTomorrow().getLove_txt());
        caifuyunshi2.setText(horoscopeBean.getTomorrow().getMoney_txt());
        gongzuoyunshi2.setText(horoscopeBean.getTomorrow().getWork_txt());
        aiqing2.setText("爱情指数：" + horoscopeBean.getTomorrow().getLove_star());
        caifu2.setText("财富指数：" + horoscopeBean.getTomorrow().getMoney_star());
        gongzuo2.setText("工作指数：" + horoscopeBean.getTomorrow().getWork_star());
        shijian2.setText("幸运时间：" + horoscopeBean.getTomorrow().getLucky_time());
        shuzi2.setText("幸运数字：" + horoscopeBean.getTomorrow().getLucky_num());
        yanse2.setText("幸运颜色：" + horoscopeBean.getTomorrow().getLucky_color());
        tommorGeneral.setText("运势简评：" + horoscopeBean.getTomorrow().getGeneral_txt());
        aiqingyunshi3.setText(horoscopeBean.getWeek().getLove_txt());
        caifuyunshi3.setText(horoscopeBean.getWeek().getMoney_txt());
        gongzuoyunshi3.setText(horoscopeBean.getWeek().getWork_txt());
        aiqing3.setText("爱情指数：" + horoscopeBean.getWeek().getLove_star());
        caifu3.setText("财富指数：" + horoscopeBean.getWeek().getMoney_star());
        gongzuo3.setText("工作指数：" + horoscopeBean.getWeek().getWork_star());
        shijian3.setText("幸运时间：" + horoscopeBean.getWeek().getLucky_day());
        shuzi3.setText("幸运数字：" + horoscopeBean.getWeek().getLucky_num());
        yanse3.setText("幸运颜色：" + horoscopeBean.getWeek().getLucky_color());
        weekGeneral.setText("运势简评：" + horoscopeBean.getWeek().getGeneral_txt());
        aiqingyunshi4.setText(horoscopeBean.getMonth().getLove_txt());
        caifuyunshi4.setText(horoscopeBean.getMonth().getMoney_txt());
        gongzuoyunshi4.setText(horoscopeBean.getMonth().getWork_txt());
        aiqing4.setText("爱情指数：" + horoscopeBean.getMonth().getLove_star());
        caifu4.setText("财富指数：" + horoscopeBean.getMonth().getMoney_star());
        gongzuo4.setText("工作指数：" + horoscopeBean.getMonth().getWork_star());
        shijian4.setText("幸运时间：" + horoscopeBean.getWeek().getLucky_day());
        shuzi4.setText("幸运数字：" + horoscopeBean.getWeek().getLucky_num());
        yanse4.setText("幸运颜色：" + horoscopeBean.getWeek().getLucky_color());
        monthGeneral.setText("运势简评：" + horoscopeBean.getWeek().getGeneral_txt());
        guiren.setText("贵人星座：" + horoscopeBean.getMonth().getGrxz());
        xiaoren.setText("小人星座：" + horoscopeBean.getMonth().getXrxz());
        yuanfen.setText("缘分星座："+horoscopeBean.getMonth().getYfxz());

    }

    @Override
    public void initListener() {

    }

    @Override
    public void processClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
