package com.yimi.pospay.ui.main.logic;

import android.content.Context;

import com.yimi.pospay.callbacks.UICallBack;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.main.contract.TransactionContract;
import com.yimi.pospay.ui.main.presenter.MainPresenter;
import com.yimi.pospay.ui.main.presenter.TransactionPresenter;

/**
 * @author 000432
 */
public class TransactionLogic extends UICallBack implements TransactionContract.Biz {

    private TransactionPresenter mPresenter;

    public TransactionLogic(TransactionPresenter mPresenter) {
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
