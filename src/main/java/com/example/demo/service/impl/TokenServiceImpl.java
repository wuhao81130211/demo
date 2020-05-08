package com.example.demo.service.impl;

import com.example.demo.common.ResponseCode;
import com.example.demo.common.ServerResponse;
import com.example.demo.constant.Constant;
import com.example.demo.service.TokenService;
import com.example.demo.utils.JedisUtils;
import com.example.demo.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
/**
 * @author: wuHao
 * @Date: 2020/4/28 11:47
 * @Description:
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_NAME = "token";
    private static int sum =0;
    @Autowired
    private JedisUtils jedisUtil;

    @Override
    public ServerResponse createToken() {
        String str = RandomUtil.UUID32();
        StrBuilder token = new StrBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);

        jedisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);

        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        // header中不存在token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TOKEN_NAME);
            // parameter中也不存在token
            if (StringUtils.isBlank(token)) {
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }

        if (!jedisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        log.info("sum:{}", ++sum);
        Long del = jedisUtil.del(token);
        log.info("del:{}", del);

        if (del <= 0) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }

}