package com.change.pet.common.enums;

/**
 * @author zhaochangzhi
 * @description 错误码枚举类
 * @date 2018/10/8 14:08
 */
public enum ResultErrorCodeEnum {

	//通用成功CODE
	SUCCESS(200, "成功"),
	//通用失败CODE
	FAILURE(500, "失败");


	private int code;
	private String message;

	ResultErrorCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage(){
		return message;
	}
	/**
	 * 根据错误码获取错误信息
	 * @param code 错误码
	 * @return message
	 */
	public String getMessage(int code) {
		String msg = "未知错误";
		for(ResultErrorCodeEnum resultErrorCode : ResultErrorCodeEnum.values()) {
			if (resultErrorCode.code == code) {
				msg = resultErrorCode.message;
				break;
			}
		}
		return msg;
	}
}
