package com.atguigu.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

import java.util.Collections;

public class AppInfoInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetail("hello","atguigu")
                .withDetails(Collections.singletonMap("world","kdfkdkf"));
    }
}
