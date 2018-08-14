package com.adifferentcolour.starter.test.support;

import com.adifferentcolour.starter.test.support.api.AppInfoAPI;
import com.adifferentcolour.starter.test.support.config.TestConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
public abstract class AcceptanceTest {

    @Autowired
    private AppInfoAPI appInfoAPI;

    protected AppInfoAPI starterAPI() {
        return appInfoAPI;
    }
}
