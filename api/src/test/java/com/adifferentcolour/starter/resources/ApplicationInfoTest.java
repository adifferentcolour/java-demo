package com.adifferentcolour.starter.resources;

import support.api.AppInfoAPI;
import support.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
public class ApplicationInfoTest {

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
