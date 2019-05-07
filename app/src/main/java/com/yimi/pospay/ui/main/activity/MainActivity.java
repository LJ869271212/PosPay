package com.yimi.pospay.ui.main.activity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
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

import com.landi.unioncodepay.UnionCodePay;
import com.yimi.pospay.R;
import com.yimi.pospay.base.BaseActivity;
import com.yimi.pospay.ui.check.activity.CheckListActivity;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.main.presenter.MainPresenter;
import com.yimi.pospay.ui.manage.activity.ManageActivity;
import com.yimi.pospay.utils.ToastUtil;
import com.yimi.pospay.utils.touchListener.TouchScaleListener;

import aldltest.yimi.com.aidltest.CalculateInterface;
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

    private UnionCodePay unionCodePay;
    private CalculateInterface calculateInterface;
    private ServiceConnection connection;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ivClear.setVisibility(View.GONE);
        btnManage.setOnTouchListener(new TouchScaleListener(0.90f));
        btnCheck.setOnTouchListener(new TouchScaleListener(0.90f));
        ivScan.setOnTouchListener(new TouchScaleListener(0.90f));
        etWaybillNo.setOnEditorActionListener(new EditorActionListener());
        etWaybillNo.addTextChangedListener(new AddTextChangeListener());

        bindRemoteService();
    }

    @OnClick({R.id.btn_manage, R.id.btn_check, R.id.iv_scan, R.id.iv_clear, R.id.btn_next_step})
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    /**
     * 绑定银联支付服务
     */
    private void bindRemoteService() {
        Intent intentService = new Intent();
        intentService.setAction("com.landi.unioncodepay");
        //兼容Android 5.0
        intentService.setPackage("com.landi.unioncodepay");
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                // 从连接中获取Stub对象
                unionCodePay = UnionCodePay.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                // 断开连接
                unionCodePay = null;
            }
        };
        startService(intentService);
        bindService(intentService, connection, Context.BIND_AUTO_CREATE);
    }

    private void bindRemoteCalService() {
        Intent intentService = new Intent();
        intentService.setAction("aldltest.yimi.com.aidltest.CalculateService");
        //兼容Android 5.0
        intentService.setPackage("aldltest.yimi.com.aidltest");
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                // 从连接中获取Stub对象
                calculateInterface = CalculateInterface.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                // 断开连接
                calculateInterface = null;
            }
        };
        startService(intentService);
        bindService(intentService, connection, Context.BIND_AUTO_CREATE);
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
            } else {
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
                Intent intent = new Intent(MainActivity.this, TransactionActivity.class);
                startActivity(intent);
//                try {
//                    double result = calculateInterface.doCalculate(3, 2);
//                    ToastUtil.showToast("result=" + result);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    unionCodePay.enterMainPage();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
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
