package com.yimi.pospay.ui.login.logic;

import android.content.Context;

import com.yimi.pospay.callbacks.UICallBack;
import com.yimi.pospay.ui.login.contract.LoginContract;
import com.yimi.pospay.ui.login.presenter.LoginPresenter;

/**
 * @author 000432
 */
public class LoginLogic extends UICallBack implements LoginContract.Biz {

    private LoginPresenter mPresenter;
    private String mCompanyCode;
    private String mEmpCode;
    private String mPwd;

    public LoginLogic(LoginPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public Context getContext() {
        return mPresenter.getContext();
    }

    @Override
    public void onError(String msg) {
    }

    @Override
    public void onError(String msg, Object obj) {
    }

    @Override
    public void onSuccess(Object obj) {
    }
}
