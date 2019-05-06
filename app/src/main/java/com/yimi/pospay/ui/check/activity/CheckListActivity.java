package com.yimi.pospay.ui.check.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yimi.pospay.R;
import com.yimi.pospay.base.BaseActivity;
import com.yimi.pospay.ui.check.contract.CheckListContract;
import com.yimi.pospay.ui.check.presenter.CheckListPresenter;
import com.yimi.pospay.utils.touchListener.TouchScaleListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: lj
 * Date: 2019/5/6 15:35
 * Description:账单列表界面
 */
public class CheckListActivity extends BaseActivity<CheckListContract.View, CheckListContract.Biz, CheckListPresenter> implements CheckListContract.Presenter {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_scan)
    ImageView ivScan;

    @Override
    public String getPageName() {
        return "账单列表界面";
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_checklist;
    }

    @Override
    public CheckListPresenter createPresenter() {
        return new CheckListPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ivBack.setOnTouchListener(new TouchScaleListener());
        ivScan.setOnTouchListener(new TouchScaleListener());
    }

    @OnClick({R.id.iv_back, R.id.iv_scan})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_scan:
                break;
            default:
                break;
        }
    }
}
