package com.rxjava.core;

/**
 * 发射器
 * <p>
 * Created by: Ysw on 2020/2/11.
 */
public interface ObservableOnSubscribe<T> extends Action<Observer<? super T>> {
}
