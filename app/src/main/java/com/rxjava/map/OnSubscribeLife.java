package com.rxjava.map;

import com.rxjava.core.ObservableOnSubscribe;
import com.rxjava.core.Observer;

/**
 * 转换操作符发射器
 * <p>
 * Created by: Ysw on 2020/2/12.
 */
public class OnSubscribeLife<T, R> implements ObservableOnSubscribe<R> {
    ObservableOnSubscribe<T> parent;
    Operator<? extends R, ? super T> operator;

    public OnSubscribeLife(ObservableOnSubscribe<T> parent, Function<? super T, ? extends R> operator) {
        this.parent = parent;
        this.operator = new OperatorMap<>(operator);
    }

    @Override
    public void subscribe(Observer<? super R> observer) {
        Observer<? super T> st = operator.apply(observer);
        parent.subscribe(st);
    }
}
