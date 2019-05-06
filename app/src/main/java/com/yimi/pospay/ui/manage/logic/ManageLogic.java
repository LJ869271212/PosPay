package com.yimi.pospay.ui.manage.logic;

import android.content.Context;

import com.yimi.pospay.callbacks.UICallBack;
import com.yimi.pospay.ui.manage.contract.ManageContract;
import com.yimi.pospay.ui.manage.presenter.ManagePresenter;

/**
 * @author 000432
 */
public class ManageLogic extends UICallBack implements ManageContract.Biz {

    private ManagePresenter mPresenter;

    public ManageLogic(ManagePresenter mPresenter) {
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
