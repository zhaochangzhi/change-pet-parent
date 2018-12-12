package com.change.pet.dao;

import com.change.pet.entity.condition.UserCondition;
import com.change.pet.entity.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhaochangzhi
 * @description
 * @date 2018/9/20 10:58
 */
@Mapper
public interface UserMapper {

	/**
	 * 根据条件查询用户列表
	 * @param condition 条件
	 * @return          列表
	 */
	List<UserPO> selectListByCondition(UserCondition condition);
}
