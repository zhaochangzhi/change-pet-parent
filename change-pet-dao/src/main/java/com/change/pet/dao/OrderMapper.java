package com.change.pet.dao;

import com.change.pet.entity.condition.OrderPageCondition;
import com.change.pet.entity.po.OrderPO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/13 14:10
 */
@Mapper
public interface OrderMapper {

  /**
   * 根据条件查询订单列表
   * @param orderPageCondition
   * @return 订单列表
   */

  List<OrderPO> getOrderList(OrderPageCondition orderPageCondition);

  /**
   * 编辑订单
   * @param orderPO
   * @return
   */
  int updateOrder(OrderPO orderPO);


  int insertOrder(OrderPO orderPO);

  int deleteById(String id);

}
