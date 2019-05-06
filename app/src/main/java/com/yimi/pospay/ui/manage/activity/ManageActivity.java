package com.yimi.pospay.ui.manage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.yimi.pospay.R;
import com.yimi.pospay.base.BaseActivity;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.manage.contract.ManageContract;
import com.yimi.pospay.ui.manage.presenter.ManagePresenter;
import com.yimi.pospay.utils.touchListener.TouchScaleListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: lj
 * Date: 2019/5/6 14:04
 * Description:管理界面
 */
public class ManageActivity extends BaseActivity<ManageContract.View, ManageContract.Biz, ManagePresenter> implements MainContract.Presenter {
    @BindView(R.id.ll_reprint)
    LinearLayout llPrint;
    @BindView(R.id.ll_sign_in)
    LinearLayout llSignIn;
    @BindView(R.id.ll_bussiness_query)
    LinearLayout llBussinessQuery;
    @BindView(R.id.ll_quit)
    LinearLayout llQuit;

    @Override
    public String getPageName() {
        return "管理界面";
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_manage;
    }

    @Override
    public ManagePresenter createPresenter() {
        return new ManagePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        llPrint.setOnTouchListener(new TouchScaleListener());
        llSignIn.setOnTouchListener(new TouchScaleListener());
        llBussinessQuery.setOnTouchListener(new TouchScaleListener());
        llQuit.setOnTouchListener(new TouchScaleListener());
    }

    @OnClick({R.id.ll_reprint, R.id.ll_sign_in, R.id.ll_bussiness_query, R.id.ll_quit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_reprint:
                break;
            case R.id.ll_sign_in:
                break;
            case R.id.ll_bussiness_query:
                break;
            case R.id.ll_quit:
                break;
            default:
                break;
        }
    }
}
