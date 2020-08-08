package com.aygunbozdemir.factorypatterndemo;

import lombok.Data;

@Data
public class Phone {

    private PhoneBrand phoneBrand;
    private String phoneModel;

    public Phone(PhoneBrand phoneBrand, String phoneModel) {
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
    }
}
