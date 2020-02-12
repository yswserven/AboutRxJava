package com.rxjava.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rxjava.R;
import com.rxjava.core.Observable;
import com.rxjava.core.ObservableOnSubscribe;
import com.rxjava.core.Observer;
import com.rxjava.map.Function;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {
                Log.d("Ysw", "onNext: " + Thread.currentThread().getName());
                observer.onNext("test");
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 100;
            }
        }).subscribeOnIO()
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Log.d("Ysw", "onNext: " + Thread.currentThread().getName());
                        Log.d("Ysw", "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
