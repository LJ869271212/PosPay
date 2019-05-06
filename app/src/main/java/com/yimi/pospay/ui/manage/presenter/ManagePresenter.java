package com.yimi.pospay.ui.manage.presenter;


import com.yimi.pospay.base.BasePresenter;
import com.yimi.pospay.ui.manage.contract.ManageContract;
import com.yimi.pospay.ui.manage.logic.ManageLogic;

/**
 * @author 000432
 */

public class ManagePresenter extends BasePresenter<ManageContract.View,ManageContract.Biz> implements ManageContract.Presenter{


    @Override
    public ManageContract.Biz createLogic() {
        return new ManageLogic(this);
    }
}
