package com.example.demo.service;


import com.example.demo.common.ServerResponse;

public interface TestService {

    ServerResponse testIdempotence();

}
