package com.change.pet.controller;

import com.alibaba.fastjson.JSON;
import com.change.pet.common.constants.LogConstants;
import com.change.pet.common.page.PageVO;
import com.change.pet.common.response.ResultVO;
import com.change.pet.entity.condition.OrderCondition;
import com.change.pet.entity.condition.OrderPageCondition;
import com.change.pet.entity.vo.OrderVO;
import com.change.pet.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description
 * @author：houlili
 * @date 2018/12/13 14:04
 */
@Log4j2
@RestController
@Api(value = "订单管理", tags = "订单列表")
@RequestMapping("/order")
public class OrderController {

  @Resource
  IOrderService orderService;

  @ApiOperation(value = "订单管理", tags = "订单列表")
  @RequestMapping(value = "orderList", method = RequestMethod.POST)
  public ResultVO orderList(@RequestBody OrderPageCondition orderPageCondition) {
    log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
        "OrderController",
        "orderList",
        JSON.toJSONString(orderPageCondition)));
    PageVO<OrderVO> page = orderService.getOrderList(orderPageCondition);
    return ResultVO.success(page);
  }

  @ApiOperation(value = "订单编辑")
  @RequestMapping(value = "updateOrder", method = RequestMethod.POST)
  public String updateOrder(@RequestBody OrderCondition orderCondition) {
    log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
        "OrderController",
        "updateOrder",
        JSON.toJSONString(orderCondition)));
    return orderService.updateOrder(orderCondition);
  }

  @ApiOperation(value = "插入订单")
  @RequestMapping(value = "insertOrder", method = RequestMethod.POST)
  public String insertOrder(@RequestBody OrderCondition orderCondition) {
    log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
        "OrderController",
        "insertOrder",
        JSON.toJSONString(orderCondition)));
    return orderService.insertOrder(orderCondition);
  }


  @ApiOperation(value = "删除订单")
  @RequestMapping(value = "deleteById", method = RequestMethod.POST)
  public String deleteById(@RequestBody OrderCondition orderCondition) {
    log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
        "OrderController",
        "deleteById",
        JSON.toJSONString(orderCondition)));
    return orderService.deleteById(orderCondition);
  }


}
