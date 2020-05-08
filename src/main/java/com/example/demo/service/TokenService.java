package com.example.demo.service;

import com.example.demo.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wuHao
 * @Date: 2020/4/28 11:46
 * @Description:
 */
public interface TokenService {

    ServerResponse createToken();

    void checkToken(HttpServletRequest request);
}
