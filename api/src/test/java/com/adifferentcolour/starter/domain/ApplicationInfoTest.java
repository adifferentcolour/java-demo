package com.adifferentcolour.starter.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ApplicationInfoTest {

    @Test
    public void should_have_name() throws Exception {
        assertThat(new ApplicationInfo().getName(), is("a-different-colour-starter"));
    }
}