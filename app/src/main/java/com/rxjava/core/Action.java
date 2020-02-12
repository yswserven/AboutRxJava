package com.rxjava.core;

/**
 * 发射器发射动作
 * <p>
 * Created by: Ysw on 2020/2/11.
 */
public interface Action<T> {
    void subscribe(T t);
}
