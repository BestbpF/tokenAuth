package com.bpf.tokenAuth.utils.token;

public class TokenModel {
	
	private Integer userId;
	
	private String token;

	public TokenModel(Integer userId, String token) {
		this.userId = userId;
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

    @Override
    public String toString() {
        return "TokenModel [userId=" + userId + ", token=" + token + "]";
    }
	
	
}
