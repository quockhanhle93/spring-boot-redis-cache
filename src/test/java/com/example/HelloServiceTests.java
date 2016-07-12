package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by taveek on 7/12/2016 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HelloServiceTests.TestConfiguration.class })
public class HelloServiceTests {

    @Autowired
    private HelloService service;

    @Test
    public void testGreetingCache() {
        String greeting1 = service.greeting(new Person("Jack", "Wealth"));
        String greeting2 = service.greeting(new Person("Jack", "Sparrow"));
        assertThat(greeting2, equalTo(greeting1));
    }

    @Configuration
    @EnableCaching
    @ComponentScan("com.example")
    public static class TestConfiguration {

        @Bean
        public CacheManager cacheManager() {
            SimpleCacheManager cacheManager = new SimpleCacheManager();
            List<Cache> caches = new ArrayList<>();
            caches.add(cacheBean().getObject());
            cacheManager.setCaches(caches);
            return cacheManager;
        }

        @Bean
        public ConcurrentMapCacheFactoryBean cacheBean() {
            ConcurrentMapCacheFactoryBean cacheFactoryBean = new ConcurrentMapCacheFactoryBean();
            cacheFactoryBean.setName("greeting");
            return cacheFactoryBean;
        }
    }
}
