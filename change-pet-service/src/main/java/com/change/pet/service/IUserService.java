package com.change.pet.service;

import com.change.pet.common.page.PageVO;
import com.change.pet.entity.condition.UserCondition;
import com.change.pet.entity.vo.UserVO;

/**
 * @author zhaochangzhi
 * @description
 * @date 2018/9/20 15:21
 */
public interface IUserService {

	/**
	 * 根据条件查询列表
	 * @param condition 条件
	 * @return          结果
	 */
	PageVO<UserVO> getListByCondition(UserCondition condition);
}
