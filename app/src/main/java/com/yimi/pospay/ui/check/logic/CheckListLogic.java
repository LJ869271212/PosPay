package com.yimi.pospay.ui.check.logic;

import android.content.Context;

import com.yimi.pospay.callbacks.UICallBack;
import com.yimi.pospay.ui.check.contract.CheckListContract;
import com.yimi.pospay.ui.check.presenter.CheckListPresenter;

/**
 * @author 000432
 */
public class CheckListLogic extends UICallBack implements CheckListContract.Biz {

    private CheckListPresenter mPresenter;

    public CheckListLogic(CheckListPresenter mPresenter) {
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
