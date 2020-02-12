package com.rxjava.thread;

import android.os.Handler;
import android.os.Looper;

import com.rxjava.core.Observable;
import com.rxjava.core.ObservableOnSubscribe;
import com.rxjava.core.Observer;

/**
 * 订阅在主线程
 * 通过主线程来创建下一个被观察者
 * <p>
 * Created by: Ysw on 2020/2/12.
 */
public class OnSubscribeOnMain<T> implements ObservableOnSubscribe<T> {
    private Handler handler;
    private Observable<T> lastObservable;

    public OnSubscribeOnMain(Observable<T> lastObservable) {
        this.lastObservable = lastObservable;
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void subscribe(final Observer<? super T> observer) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                lastObservable.subscribe(observer);
            }
        });
    }
}
