package com.change.pet.service.impl;

import com.change.pet.common.page.PageVO;
import com.change.pet.dao.UserMapper;
import com.change.pet.entity.condition.UserCondition;
import com.change.pet.entity.po.UserPO;
import com.change.pet.entity.vo.UserVO;
import com.change.pet.service.IUserService;
import com.github.pagehelper.Page;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaochangzhi
 * @description
 * @date 2018/9/20 15:21
 */
@Log4j2
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public PageVO<UserVO> getListByCondition(UserCondition condition) {
		List<UserPO> userPOs = userMapper.selectListByCondition(condition);
		Page page = (Page)userPOs;
		List<UserVO> userVOs = new ArrayList<>();
		for (UserPO userPO : userPOs) {
			UserVO userVO = new UserVO();
			userVO.setId(userPO.getId());
			userVOs.add(userVO);
		}
		return new PageVO<UserVO>(page).setList(userVOs);
	}
}