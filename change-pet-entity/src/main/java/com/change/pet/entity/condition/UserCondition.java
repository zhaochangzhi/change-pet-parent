package com.change.pet.entity.condition;

import com.change.pet.common.page.PageCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhaochangzhi
 * @description
 * @date 2018/9/20 11:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserCondition extends PageCondition {

	/**
	 * 用户id
	 */
	private String id;
}
