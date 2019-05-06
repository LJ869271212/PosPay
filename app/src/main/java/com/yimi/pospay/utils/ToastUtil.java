package com.yimi.pospay.utils;

import android.widget.Toast;

import com.yimi.pospay.ui.PosApplication;

/**
 * @author: lj
 * Date: 2019/5/6 11:17
 */
public class ToastUtil {

    private static Toast toast;

    public static void showToast(String msg) {
        if (PosApplication.getAppContext() != null) {
            if (toast != null) {
                toast.cancel();
            }
            toast = Toast.makeText(PosApplication.getAppContext(), msg, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
