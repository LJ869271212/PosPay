package com.yimi.pospay.ui.main.logic;

import android.content.Context;

import com.yimi.pospay.callbacks.UICallBack;
import com.yimi.pospay.ui.login.contract.LoginContract;
import com.yimi.pospay.ui.login.presenter.LoginPresenter;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.main.presenter.MainPresenter;

/**
 * @author 000432
 */
public class MainLogic extends UICallBack implements MainContract.Biz {

    private MainPresenter mPresenter;

    public MainLogic(MainPresenter mPresenter) {
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
