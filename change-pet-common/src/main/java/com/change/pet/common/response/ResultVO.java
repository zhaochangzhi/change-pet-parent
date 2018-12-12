package com.change.pet.common.response;

import com.change.pet.common.enums.ResultErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * api通用返回值
 *
 * @author zhaochangzhi
 * @description
 * @date 2018/9/20 14:52
 */
@Data
@AllArgsConstructor
public class ResultVO<T> {

	/**
	 * 请求返回码
	 */
	private Integer code;

	/**
	 * 返回信息
	 */
	private String message;

	/**
	 * 返回数据
	 */
	private T data;

	/**
	 * 请求成功通用方法
	 * @param data      数据
	 * @return          结果
	 */
	public static <T> ResultVO<T> success(T data) {
		return new ResultVO<>(ResultErrorCodeEnum.SUCCESS.getCode(), ResultErrorCodeEnum.SUCCESS.getMessage(), data);
	}

	/**
	 * 请求失败通用方法
	 * @param code      错误码
	 * @param message   信息
	 * @return          结果
	 */
	public static <T> ResultVO<T> failure(Integer code, String message) {
        return new ResultVO<>(code, message, null);
	}
}
