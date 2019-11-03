package com.gsj.www.redis_token.service;

import com.gsj.www.redis_token.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    ServerResponse createToken();
    void checkToken(HttpServletRequest request);

}
