package com.gsj.www.redis_token.service.impl;

import com.gsj.www.redis_token.util.JedisUtil;
import com.gsj.www.redis_token.common.ServerResponse;
import com.gsj.www.redis_token.service.TokenService;
import com.gsj.www.redis_token.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {
    private static final String TOKEN_NAME = "token";

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public ServerResponse createToken() {
//        String str = RandomUtil.UUID32();
        StringBuilder token = new StringBuilder();
        return null;
    }

    @Override
    public void checkToken(HttpServletRequest request) {

    }
}
