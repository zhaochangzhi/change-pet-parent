package com.change.pet.service;

import com.change.pet.common.page.PageVO;
import com.change.pet.entity.condition.OrderCondition;
import com.change.pet.entity.condition.OrderPageCondition;
import com.change.pet.entity.vo.OrderVO;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/13 14:12
 */
public interface IOrderService {

  /**
   * 获取订单列表
   */
  PageVO<OrderVO> getOrderList(OrderPageCondition orderPageCondition);

  String updateOrder(OrderCondition orderCondition);

  String insertOrder(OrderCondition orderCondition);

  String deleteById(OrderCondition orderCondition);

}
