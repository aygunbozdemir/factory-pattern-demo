package com.aygunbozdemir.factorypatterndemo;

import org.springframework.stereotype.Service;

@Service
class PhoneServiceRouter implements IPhoneServiceRouter {

    private final ApplePhoneService applePhoneService;
    private final SamsungPhoneService samsungPhoneService;

    PhoneServiceRouter(ApplePhoneService applePhoneService, SamsungPhoneService samsungPhoneService) {
        this.applePhoneService = applePhoneService;
        this.samsungPhoneService = samsungPhoneService;
    }

    @Override
    public IPhoneService get(PhoneBrand phoneBrand) {
        switch (phoneBrand) {
            case APPLE:
                return applePhoneService;
            case SAMSUNG:
                return samsungPhoneService;
            default:
                throw new IllegalStateException("Not technical service found for :" + phoneBrand.toString());
        }
    }
}
