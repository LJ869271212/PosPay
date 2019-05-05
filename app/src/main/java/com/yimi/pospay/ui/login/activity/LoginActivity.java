package com.yimi.pospay.ui.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yimi.pospay.R;
import com.yimi.pospay.base.BaseActivity;
import com.yimi.pospay.ui.login.contract.LoginContract;
import com.yimi.pospay.ui.login.presenter.LoginPresenter;
import com.yimi.pospay.ui.main.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录界面
 *
 * @author lj
 */
public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Biz, LoginPresenter>
        implements LoginContract.View {

    @BindView(R.id.button_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getPageName() {
        return "登录界面";
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void loginSuccess(String pwd) {

    }

    @OnClick({R.id.button_login})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
