package com.change.pet.controller;

import com.alibaba.fastjson.JSON;
import com.change.pet.common.constants.LogConstants;
import com.change.pet.common.page.PageVO;
import com.change.pet.common.response.ResultVO;
import com.change.pet.entity.condition.UserCondition;
import com.change.pet.entity.vo.UserVO;
import com.change.pet.service.IUserService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhaochangzhi
 * @description
 * @date 2018/9/14 17:50
 */
@Log4j2
@RestController
@Api(value = "首页", tags = "首页")
public class IndexController {

	@Resource
	private IUserService userService;

	@ApiOperation(value = "首页", notes = "首页")
	@RequestMapping(value = "index", method = RequestMethod.POST)
	public ResultVO index(@RequestBody UserCondition condition) {
		log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
				"IndexController",
				"index",
				JSON.toJSONString(condition)));
		//使用page helper
		PageHelper.startPage(condition.getPageNo(), condition.getPageSize());
		PageVO<UserVO> page = userService.getListByCondition(condition);
		return ResultVO.success(page);
	}
}
