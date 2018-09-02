package com.bpf.tokenAuth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpf.tokenAuth.annotation.NoneAuth;
import com.bpf.tokenAuth.constant.MessageConstant;
import com.bpf.tokenAuth.constant.NormalConstant;
import com.bpf.tokenAuth.entity.JsonData;
import com.bpf.tokenAuth.entity.User;
import com.bpf.tokenAuth.enums.HttpStatusEnum;
import com.bpf.tokenAuth.mapper.UserMapper;
import com.bpf.tokenAuth.utils.token.TokenHelper;
import com.bpf.tokenAuth.utils.token.TokenModel;

@RestController
@RequestMapping("/token")
public class TokenController {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private TokenHelper tokenHelper;
	
    @NoneAuth
	@GetMapping
	public Object login(String username, String password) {
	    User user = userMapper.findByName(username);
	    if(user == null || !user.getPassword().equals(password)) {
	        return JsonData.buildError(HttpStatusEnum.NOT_FOUND.getCode(), MessageConstant.USERNAME_OR_PASSWORD_ERROR);
	    }
	    
	    TokenModel model = tokenHelper.create(user.getId());
	    return JsonData.buildSuccess(model);    
	}
	
	@DeleteMapping
	public Object logout(HttpServletRequest request) {
	    Integer userId = (Integer) request.getAttribute(NormalConstant.CURRENT_USER_ID);
	    if(userId != null) {
	        tokenHelper.delete(userId);
	    }
	    return JsonData.buildSuccess();
	}

}
