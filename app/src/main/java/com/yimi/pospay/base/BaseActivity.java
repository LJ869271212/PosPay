package com.yimi.pospay.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yimi.pospay.utils.ActivityStack;

import butterknife.ButterKnife;


/**
 * @author 000432
 */

public abstract class BaseActivity<V extends BaseContract.BaseView, H extends BaseContract.BaseBiz, T extends BasePresenter<V, H>>
        extends AppCompatActivity implements BaseContract.BaseView {

    /**
     * Presenter 泛型变量
     */
    protected T mT;
    protected boolean isScan = false;

    public BaseActivity() {
        isScan = false;
    }

    public BaseActivity(boolean isScan) {
        this.isScan = isScan;
    }

    /**
     * 提供页面统计名称的方法, 由子类实现
     */
    public abstract String getPageName();
    public abstract int getContentViewId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStack.getInstance().addActivity(this);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        mT = createPresenter();
        mT.onAttach((V) this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (isScan) {
            enableScan();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (isScan) {
            disableScan();
        }
    }

    public void enableScan() {
    }

    public void disableScan() {
    }

    /**
     * 创建一个指定的Presenter
     *
     * @return 指定的Presenter t
     */
    public abstract T createPresenter();

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String getTAG() {
        return getContext().getClass().getName();
    }

    public void toActivity(Class mClass) {
        Intent intent = new Intent(this, mClass);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mT.onDetach();
        ActivityStack.getInstance().deleteActivity(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
