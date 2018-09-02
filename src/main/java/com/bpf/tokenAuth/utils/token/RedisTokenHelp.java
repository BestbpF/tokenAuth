package com.bpf.tokenAuth.utils.token;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bpf.tokenAuth.utils.RedisClient;

@Component
public class RedisTokenHelp implements TokenHelper {
    
    @Autowired
    private RedisClient redisClient;

    @Override
    public TokenModel create(Integer id) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel mode = new TokenModel(id, token);
        redisClient.set(id == null ? null : String.valueOf(id), token, RedisClient.TOKEN_EXPIRES_SECOND);
        return mode;
    }

    @Override
    public boolean check(TokenModel model) {
        boolean result = false;
        if(model != null) {
            String userId = model.getUserId().toString();
            String token = model.getToken();
            String authenticatedToken = redisClient.get(userId);
            if(authenticatedToken != null && authenticatedToken.equals(token)) {
                redisClient.expire(userId, RedisClient.TOKEN_EXPIRES_SECOND);
                result = true;
            }
        }
        return result;
    }

    @Override
    public TokenModel get(String authStr) {
        TokenModel model = null;
        if(StringUtils.isNotEmpty(authStr)) {
            String[] modelArr = authStr.split("_");
            if(modelArr.length == 2) {
                int userId = Integer.parseInt(modelArr[0]);
                String token = modelArr[1];
                model = new TokenModel(userId, token);
            }
        }
        return model;
    }

    @Override
    public boolean delete(Integer id) {
        return redisClient.remove(id == null ? null : String.valueOf(id));
    }

}
