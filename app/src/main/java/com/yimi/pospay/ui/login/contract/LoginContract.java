package com.yimi.pospay.ui.login.contract;


import com.yimi.pospay.base.BaseContract;

/**
 * @author 000432
 */

public interface LoginContract {

    interface View extends BaseContract.BaseView {

        /**
         * 登录成功
         *
         * @param pwd 密码
         */
        void loginSuccess(String pwd);
    }

    interface Presenter extends BaseContract.BasePresenter {

    }

    interface Biz extends BaseContract.BaseBiz {

    }
}
