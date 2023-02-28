package com.sie.app.feigndemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chun
 */
@FeignClient(name = "storeClient", url = "http://localhost:9778")
public interface StoreClient {

    @GetMapping("checkhealth")
    public String checkHealth();

}