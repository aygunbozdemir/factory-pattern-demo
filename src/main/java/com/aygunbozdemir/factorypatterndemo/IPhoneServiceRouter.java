package com.aygunbozdemir.factorypatterndemo;

public interface IPhoneServiceRouter<T> {

    T get(PhoneBrand phoneBrand);
}
