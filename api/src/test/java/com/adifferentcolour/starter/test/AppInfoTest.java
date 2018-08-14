package com.adifferentcolour.starter.test;

import com.adifferentcolour.starter.test.support.api.AppInfoAPI;
import com.adifferentcolour.starter.test.support.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
public class AppInfoTest {

    @Autowired
    private AppInfoAPI appInfoAPI;

    @Test
    public void should_return_app_status() {
        assertThat(appInfoAPI.getStatus(), is("ok"));
    }

    @Test
    public void should_return_app_name() {
        assertThat(appInfoAPI.getAppInfo().getName(), is("java-demo"));
    }

}
