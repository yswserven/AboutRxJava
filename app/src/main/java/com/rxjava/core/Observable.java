package com.rxjava.core;

import com.rxjava.map.Function;
import com.rxjava.map.OnSubscribeLife;
import com.rxjava.thread.OnSubscribeOnIO;
import com.rxjava.thread.OnSubscribeOnMain;

/**
 * 被观察者
 * <p>
 * Created by: Ysw on 2020/2/11.
 */
public class Observable<T> {
    private ObservableOnSubscribe onSubscribe;

    private Observable(ObservableOnSubscribe onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> onSubscribe) {
        return new Observable<>(onSubscribe);
    }

    public void subscribe(Observer<? super T> subscribe) {
        onSubscribe.subscribe(subscribe);
    }

    public <R> Observable<R> map(Function<? super T, ? extends R> function) {
        return new Observable<>(new OnSubscribeLife(onSubscribe, function));

    }

    /**
     * 订阅在IO线程
     *
     * @author Ysw created at 2020/2/12 19:42
     */
    public Observable<T> subscribeOnIO() {
        return create(new OnSubscribeOnIO<>(this));
    }

    /**
     * 订阅在主线程
     *
     * @author Ysw created at 2020/2/12 19:42
     */
    public Observable<T> subscribeOnMain() {
        return create(new OnSubscribeOnMain<>(this));
    }
}
