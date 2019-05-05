package com.yimi.pospay.ui.login.presenter;

import com.yimi.pospay.base.BasePresenter;
import com.yimi.pospay.ui.login.contract.LoginContract;
import com.yimi.pospay.ui.login.logic.LoginLogic;

/**
 * @author 000432
 */

public class LoginPresenter extends BasePresenter<LoginContract.View, LoginContract.Biz> implements LoginContract.Presenter {

    @Override
    public LoginContract.Biz createLogic() {
        return new LoginLogic(this);
    }

}
