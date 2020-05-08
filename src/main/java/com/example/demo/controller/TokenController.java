package com.example.demo.controller;

import com.example.demo.annotation.ApiIdempotent;
import com.example.demo.common.ServerResponse;
import com.example.demo.service.TestService;
import com.example.demo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wuHao
 * @Date: 2020/4/28 13:17
 * @Description:
 */
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TestService testService;

    @GetMapping(value = "/token",produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse token() {
        return tokenService.createToken();
    }

    @ApiIdempotent
    @PostMapping(value = "/testIdempotence",produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse testIdempotence(String token) {
        return testService.testIdempotence();
    }

}
