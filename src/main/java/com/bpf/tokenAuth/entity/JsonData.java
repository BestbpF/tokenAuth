package com.bpf.tokenAuth.entity;

import java.io.Serializable;

import com.bpf.tokenAuth.enums.HttpStatusEnum;

public class JsonData implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer code; // 状态码 对应httpstatus中的状态码
	private Object data; // 数据
	private String msg;// 描述

	public JsonData() {
	}

	public JsonData(Integer code, Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	/**
	 * @return 成功，包含默认200状态码和【请求成功】描述
	 */
	public static JsonData buildSuccess() {
		return new JsonData(HttpStatusEnum.SUCCESS.getCode(), null, HttpStatusEnum.SUCCESS.getInfo());
	}

	/**
	 * @param data 数据
	 * @return 成功，包含默认200状态码和【请求成功】描述
	 */
	public static JsonData buildSuccess(Object data) {
		return new JsonData(HttpStatusEnum.SUCCESS.getCode(), data, HttpStatusEnum.SUCCESS.getInfo());
	}
	
    /**
     * @param data 数据
     * @param msg 描述信息
     * @return 成功，包含默认200状态码
     */
    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(HttpStatusEnum.SUCCESS.getCode(), data, msg);
    }

    /**
     * @param data 数据
     * @param code 状态码
     * @return 成功，不包含描述信息
     */
    public static JsonData buildSuccess(Object data, int code) {
        return new JsonData(code, data, null);
    }

	/**
	 * @param code 状态码
	 * @param msg 描述信息
	 * @return 失败
	 */
	public static JsonData buildError(Integer code, String msg) {
		return new JsonData(code, null, msg);
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "JsonData [code=" + code + ", data=" + data + ", msg=" + msg
				+ "]";
	}

}
