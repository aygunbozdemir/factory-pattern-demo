package com.aygunbozdemir.factorypatterndemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.aygunbozdemir.factorypatterndemo.PhoneBrand.APPLE;
import static com.aygunbozdemir.factorypatterndemo.PhoneBrand.SAMSUNG;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FactoryPatternDemoApplicationTests {

    @Autowired
    PhoneServiceRouter phoneServiceRouter;

    @Test
    public void contextLoads() {
    }

    @Test
    public void should_not_route_apple_phone_service_for_samsung_phone_apply() {

        Phone phone = new Phone(SAMSUNG, "Samsung Galaxy S10 Pro");

        IPhoneService samsungPhoneService = phoneServiceRouter.get(phone.getPhoneBrand());

        String serviceName = samsungPhoneService.getClass().getSimpleName();
        assertNotEquals(serviceName, "phoneService");
    }

    @Test
    public void should_route_apple_phone_service_for_apple_phone_apply() {

        Phone phone = new Phone(APPLE, "IPhone SE 2020 64GB");

        IPhoneService applePhoneService = phoneServiceRouter.get(phone.getPhoneBrand());

        String serviceName = applePhoneService.getClass().getSimpleName();
        assertEquals(serviceName, "ApplePhoneService");
    }

    @Test
    public void should_not_route_samsung_phone_service_for_apple_phone_apply() {

        Phone phone = new Phone(APPLE, "Samsung Galaxy S10 Pro");

        IPhoneService applePhoneService = phoneServiceRouter.get(phone.getPhoneBrand());

        String serviceName = applePhoneService.getClass().getSimpleName();
        assertNotEquals(serviceName, "SamsungPhoneService");
    }

    @Test
    public void should_route_samsung_phone_service_for_samsung_phone_apply() {

        Phone phone = new Phone(SAMSUNG, "Samsung Galaxy S10 Pro");

        IPhoneService samsungPhoneService = phoneServiceRouter.get(phone.getPhoneBrand());

        String serviceName = samsungPhoneService.getClass().getSimpleName();
        assertEquals(serviceName, "SamsungPhoneService");
    }

    @Test
    public void user_should_apply_apple_phone_to_phone_service() {

        Phone phone = new Phone(APPLE, "IPhone SE 2020 64GB");

        IPhoneService applePhoneService = phoneServiceRouter.get(phone.getPhoneBrand());

        ApplyResult result = applePhoneService.apply(phone);

        assertNotNull(result.getApplyId());
        assertEquals(phone.getPhoneBrand(), result.getPhone().getPhoneBrand());
    }

    @Test
    public void user_should_apply_samsung_phone_to_phone_service() {

        Phone phone = new Phone(SAMSUNG, "Samsung Galaxy S10 Pro");

        IPhoneService samsungPhoneService = phoneServiceRouter.get(phone.getPhoneBrand());

        ApplyResult result = samsungPhoneService.apply(phone);

        assertNotNull(result.getApplyId());
        assertEquals(phone.getPhoneBrand(), result.getPhone().getPhoneBrand());
    }
}
