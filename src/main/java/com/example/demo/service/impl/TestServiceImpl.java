package com.example.demo.service.impl;

import com.example.demo.common.ServerResponse;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wold
 */
@Service
public class TestServiceImpl implements TestService {


    @Override
    public ServerResponse testIdempotence() {
        return ServerResponse.success("testIdempotence: success",123);
    }



}
