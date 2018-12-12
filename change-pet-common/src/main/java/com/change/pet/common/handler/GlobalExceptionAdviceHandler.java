package com.change.pet.common.handler;

import com.change.pet.common.enums.ResultErrorCodeEnum;
import com.change.pet.common.response.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaochangzhi
 * @description 全局异常处理类
 * @date 2018/10/8 14:00
 */
@ControllerAdvice
public class GlobalExceptionAdviceHandler {

	/**
	 * 全局异常处理
	 * @param e         异常
	 * @param request   请求
	 * @param response  结果响应
	 * @return          返回值
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResultVO handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
		return ResultVO.failure(ResultErrorCodeEnum.FAILURE.getCode(), e.getMessage());
	}

}
