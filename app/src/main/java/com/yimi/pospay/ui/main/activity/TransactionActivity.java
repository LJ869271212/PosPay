package com.yimi.pospay.ui.main.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.ldoublem.loadingviewlib.view.LVCircularZoom;
import com.yimi.pospay.R;
import com.yimi.pospay.base.BaseActivity;
import com.yimi.pospay.ui.main.contract.TransactionContract;
import com.yimi.pospay.ui.main.presenter.TransactionPresenter;

import butterknife.BindView;

/**
 * @author: lj
 * Date: 2019/5/7 17:35
 * Description:交易中界面
 */
public class TransactionActivity extends BaseActivity<TransactionContract.View, TransactionContract.Biz, TransactionPresenter> implements TransactionContract.Presenter {
    @BindView(R.id.lv_circularZoom)
    LVCircularZoom mLVCircularZoom;

    @Override
    public String getPageName() {
        return "交易中界面";
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_transaction;
    }

    @Override
    public TransactionPresenter createPresenter() {
        return new TransactionPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLVCircularZoom.setViewColor(ContextCompat.getColor(this, R.color.black));
        mLVCircularZoom.startAnim();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLVCircularZoom.stopAnim();
    }
}
