package com.yimi.pospay.base;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * @author 000432
 */

public abstract class BasePresenter<V extends BaseContract.BaseView, H extends BaseContract.BaseBiz> {
  /**
   * Activity
   */
  protected WeakReference<V> mReference;
  /**
   * 具体业务实现
   */
  protected H mLogic;

  /**
   * 装载Activity
   *
   * @param mView the m view
   */
  public void onAttach(V mView) {
    mReference = new WeakReference<V>(mView);
    mLogic = createLogic();
  }

  /**
   * 创建指定的业务实现
   *
   * @return 业务实现类变量 h
   */
  public abstract H createLogic();

  /**
   * 获取Activity View的实现
   *
   * @return Activity ： 可能为null，需要做null处理
   */
  public V getReference() {
    return mReference == null ? null : mReference.get();
  }

  /**
   * 卸载Activity
   */
  public void onDetach() {
    if (mReference != null) {
      mReference.clear();
      mReference = null;
    }
    mLogic = null;
  }

  /**
   * 获取业务实现
   *
   * @return the logic
   */
  public H getLogic() {
    return mLogic;
  }

  /**
   * 当前Activity或Fragment的上下文
   *
   * @return 上下文 context
   */
  //    @Deprecated
  public Context getContext() {
    return getReference().getContext();
  }

  /**
   * 取得当前Activity或Fragment的TAG，可用于请求TAG标记和日志标记等
   *
   * @return the tag
   */
  //    @Deprecated
  public String getTAG() {
    return getReference().getTAG();
  }
}
