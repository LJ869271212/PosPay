package com.yimi.pospay.ui.main.presenter;


import com.yimi.pospay.base.BasePresenter;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.main.logic.MainLogic;

/**
 * @author 000432
 */

public class MainPresenter extends BasePresenter<MainContract.View,MainContract.Biz> implements MainContract.Presenter{


    @Override
    public MainContract.Biz createLogic() {
        return new MainLogic(this);
    }
}
