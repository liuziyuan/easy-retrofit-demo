package io.github.liuziyuan.retrofit.spring.boot.web.samples.controller;

import io.github.liuziyuan.retrofit.spring.boot.web.samples.api.HelloApi;
import io.github.liuziyuan.retrofit.spring.boot.web.samples.domain.HelloBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class HelloControllerTest {
    @Mock
    HelloApi helloApi;
    @Mock
    Logger log;
    @InjectMocks
    HelloController helloController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHello() throws Exception {
        when(helloApi.hello(anyString())).thenReturn(new HelloBean());

        ResponseEntity<HelloBean> result = helloController.hello("message");
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme