package com.rxjava.map;

import com.rxjava.core.Observer;

/**
 * 转换操作符
 * <p>
 * Created by: Ysw on 2020/2/12.
 */
public class OperatorMap<T, R> implements Operator<R, T> {
    private Function<? super T, ? extends R> function;

    public OperatorMap(Function<? super T, ? extends R> function) {
        this.function = function;
    }

    @Override
    public Observer<? super T> apply(Observer<? super R> observer) {
        return new MapSubscribe<>(function, observer);
    }


    private class MapSubscribe<T, R> extends Observer<T> {

        private Function<? super T, ? extends R> transform;
        private Observer<? super R> actual;

        MapSubscribe(Function<? super T, ? extends R> transform, Observer<? super R> actual) {
            this.transform = transform;
            this.actual = actual;
        }

        @Override
        public void onNext(T t) {
            R apply = transform.apply(t);
            actual.onNext(apply);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
