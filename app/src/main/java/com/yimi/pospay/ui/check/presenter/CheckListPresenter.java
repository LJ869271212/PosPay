package com.yimi.pospay.ui.check.presenter;


import com.yimi.pospay.base.BasePresenter;
import com.yimi.pospay.ui.check.contract.CheckListContract;
import com.yimi.pospay.ui.check.logic.CheckListLogic;

/**
 * @author 000432
 */

public class CheckListPresenter extends BasePresenter<CheckListContract.View,CheckListContract.Biz> implements CheckListContract.Presenter{


    @Override
    public CheckListContract.Biz createLogic() {
        return new CheckListLogic(this);
    }
}
