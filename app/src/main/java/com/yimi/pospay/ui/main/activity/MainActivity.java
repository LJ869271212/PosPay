package com.yimi.pospay.ui.main.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yimi.pospay.R;
import com.yimi.pospay.base.BaseActivity;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.main.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: lj
 * Date: 2019/5/5 16:24
 * Description: 主页收款界面
 */
public class MainActivity extends BaseActivity<MainContract.View, MainContract.Biz, MainPresenter> implements MainContract.View {

    @BindView(R.id.tv_manage)
    TextView tvmanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getPageName() {
        return "主页收款界面";
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @OnClick({R.id.tv_manage})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.tv_manage:
                Toast.makeText(this,"点击了管理", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
