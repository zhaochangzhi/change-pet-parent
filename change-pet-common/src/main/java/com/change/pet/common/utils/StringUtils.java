package com.change.pet.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author zhaochangzhi
 * @description 字符串工具类
 * @date 2018/10/8 17:25
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	/**
	 * 生成32位uuid
	 * @return 32位uuid
	 */
	public static String generate32UUID() {

		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 请求体获取远程ip地址
	 * @param request 请求体
	 * @return 远程ip地址
	 */
	public static String getRemoteAddress(HttpServletRequest request) {

		String remoteAddress = request.getHeader("X-Real-IP");
		if (isNotBlank(remoteAddress)) {
			remoteAddress = request.getHeader("X-Forwarded-For");
		} else if (isNotBlank(remoteAddress)) {
			remoteAddress = request.getHeader("Proxy-Client-IP");
		} else if (isNotBlank(remoteAddress)) {
			remoteAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddress != null ? remoteAddress : request.getRemoteAddr();
	}
}
