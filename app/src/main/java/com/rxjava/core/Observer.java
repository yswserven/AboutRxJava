package com.rxjava.core;

/**
 * 观察者
 * <p>
 * Created by: Ysw on 2020/2/11.
 */
public abstract class Observer<T> {

    public abstract void onNext(T t);

    public abstract void onError(Throwable e);

    public abstract void onComplete();
}
