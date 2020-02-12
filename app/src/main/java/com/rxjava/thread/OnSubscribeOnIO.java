package com.rxjava.thread;

import com.rxjava.core.Observable;
import com.rxjava.core.ObservableOnSubscribe;
import com.rxjava.core.Observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 订阅在IO线程
 * 通过子线程来创建下一个被观察者
 * <p>
 * Created by: Ysw on 2020/2/12.
 */
public class OnSubscribeOnIO<T> implements ObservableOnSubscribe<T> {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private Observable<T> lastObserver;

    public OnSubscribeOnIO(Observable<T> lastObserver) {
        this.lastObserver = lastObserver;
    }

    @Override
    public void subscribe(final Observer<? super T> observer) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                lastObserver.subscribe(observer);
            }
        });
    }
}
