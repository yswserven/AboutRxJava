package com.rxjava.map;

import com.rxjava.core.Observer;

/**
 * Created by: Ysw on 2020/2/12.
 */
public interface Operator<T, R> extends Function<Observer<? super T>, Observer<? super R>> {
}
