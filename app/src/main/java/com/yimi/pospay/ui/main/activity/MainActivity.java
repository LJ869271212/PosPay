package com.yimi.pospay.ui.main.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yimi.pospay.R;
import com.yimi.pospay.base.BaseActivity;
import com.yimi.pospay.ui.check.activity.CheckListActivity;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.main.presenter.MainPresenter;
import com.yimi.pospay.ui.manage.activity.ManageActivity;
import com.yimi.pospay.utils.ToastUtil;
import com.yimi.pospay.utils.touchListener.TouchScaleListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: lj
 * Date: 2019/5/5 16:24
 * Description: 主页收款界面
 */
public class MainActivity extends BaseActivity<MainContract.View, MainContract.Biz, MainPresenter> implements MainContract.View {

    /**
     * 管理
     */
    @BindView(R.id.btn_manage)
    Button btnManage;
    /**
     * 账单
     */
    @BindView(R.id.btn_check)
    Button btnCheck;
    /**
     * 扫描
     */
    @BindView(R.id.iv_scan)
    ImageView ivScan;
    /**
     * 运单号输入框
     */
    @BindView(R.id.et_waybillNo)
    EditText etWaybillNo;
    @BindView(R.id.iv_clear)
    ImageView ivClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ivClear.setVisibility(View.GONE);
        btnManage.setOnTouchListener(new TouchScaleListener(0.90f));
        btnCheck.setOnTouchListener(new TouchScaleListener(0.90f));
        ivScan.setOnTouchListener(new TouchScaleListener(0.90f));
        etWaybillNo.setOnEditorActionListener(new EditorActionListener());
        etWaybillNo.addTextChangedListener(new AddTextChangeListener());
    }

    @Override
    public String getPageName() {
        return "主页收款界面";
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @OnClick({R.id.btn_manage, R.id.btn_check, R.id.iv_scan, R.id.iv_clear,R.id.btn_next_step})
    public void onclick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_manage:
                //跳转至管理界面
                intent = new Intent(this, ManageActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_check:
                //跳转至账单界面
                intent = new Intent(this, CheckListActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_clear:
                ivClear.setVisibility(View.GONE);
                etWaybillNo.setText("");
                break;
            case R.id.btn_next_step:
                showBottomDialog();
                break;
            default:
                break;
        }
    }

    /**
     * 键盘按键监听
     */
    private class EditorActionListener implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                ToastUtil.showToast("点击了下一步");
                return true;
            }
            return false;
        }
    }


    private class AddTextChangeListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().length() > 0) {
                ivClear.setVisibility(View.VISIBLE);
            }else{
                ivClear.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 显示底部弹框
     */
    private void showBottomDialog() {
        Dialog bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_main, null);
        LinearLayout llScanPay = contentView.findViewById(R.id.ll_scan_pay);
        LinearLayout llPayCard = contentView.findViewById(R.id.ll_pay_card);
        llScanPay.setOnTouchListener(new TouchScaleListener());
        llPayCard.setOnTouchListener(new TouchScaleListener());
        llScanPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("点击了扫码支付");
            }
        });
        llPayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast("点击了刷卡支付");
            }
        });
        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        bottomDialog.show();
    }
}
