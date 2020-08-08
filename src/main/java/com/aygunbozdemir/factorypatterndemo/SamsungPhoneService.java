package com.aygunbozdemir.factorypatterndemo;

import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.aygunbozdemir.factorypatterndemo.Status.ACCEPT;

@Service
public class SamsungPhoneService implements IPhoneService {

    @Override
    public ApplyResult apply(Phone phone) {

        String applyId = UUID.randomUUID().toString();
        return new ApplyResult(applyId,phone, ACCEPT);
    }
}
