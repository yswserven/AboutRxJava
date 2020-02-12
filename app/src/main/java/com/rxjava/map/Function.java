package com.rxjava.map;

/**
 * 通过泛型接口实现类型转换
 * <p>
 * Created by: Ysw on 2020/2/12.
 */
public interface Function<T, R> {
    R apply(T t);
}
