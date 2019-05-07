package com.yimi.pospay.ui.main.presenter;


import com.yimi.pospay.base.BasePresenter;
import com.yimi.pospay.ui.main.contract.MainContract;
import com.yimi.pospay.ui.main.contract.TransactionContract;
import com.yimi.pospay.ui.main.logic.MainLogic;
import com.yimi.pospay.ui.main.logic.TransactionLogic;

/**
 * @author 000432
 */

public class TransactionPresenter extends BasePresenter<TransactionContract.View,TransactionContract.Biz> implements TransactionContract.Presenter{


    @Override
    public TransactionContract.Biz createLogic() {
        return new TransactionLogic(this);
    }
}
