package com.change.pet.service.impl;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSON;
import com.change.pet.common.constants.LogConstants;
import com.change.pet.common.enums.DeliveryTypeEnum;
import com.change.pet.common.enums.OrderStatusEnum;
import com.change.pet.common.enums.OrderTypeEnum;
import com.change.pet.common.enums.ResultErrorCodeEnum;
import com.change.pet.common.page.PageVO;
import com.change.pet.dao.OrderMapper;
import com.change.pet.entity.condition.OrderCondition;
import com.change.pet.entity.condition.OrderPageCondition;
import com.change.pet.entity.po.OrderPO;
import com.change.pet.entity.vo.OrderVO;
import com.change.pet.service.IOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.corba.se.impl.ior.ObjectReferenceProducerBase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import org.springframework.stereotype.Service;
import sun.plugin2.main.server.IExplorerPlugin;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/13 14:13
 */

@Log4j2
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

  @Resource
  private OrderMapper orderMapper;

  /**
   * 获取订单分页列表
   *
   * @return PageVO<OrderVO>
   */
  @Override
  public PageVO<OrderVO> getOrderList(OrderPageCondition orderPageCondition) {
    log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
        "OrderServiceImpl",
        "getOrderList",
        JSON.toJSONString(orderPageCondition)));

    //使用page helper
    PageHelper.startPage(orderPageCondition.getPageNo(), orderPageCondition.getPageSize());
    //获取订单列表
    List<OrderPO> orderPOS = orderMapper.getOrderList(orderPageCondition);
    Page page = (Page) orderPOS;
    List<OrderVO> orderVOS = new ArrayList<>();
    //设置日期格式
    String format = "yyyy-MM-dd HH:mm:ss";

    for (OrderPO orderPO : orderPOS) {
      OrderVO orderVO = new OrderVO();
      orderVO.setOrderSn(orderPO.getOrderSn());
      orderVO.setOrderType(OrderTypeEnum.getEnumDesc(orderPO.getOrderType()));
      orderVO.setOrderStatus(OrderStatusEnum.getEnumDesc(orderPO.getOrderStatus()));
      orderVO.setOrderSource(OrderStatusEnum.getEnumDesc(orderPO.getOrderSource()));
      orderVO.setDeliveryType(DeliveryTypeEnum.getEnumDesc(orderPO.getDeliveryType()));
      orderVO.setTradingPrice(
          orderPO.getTradingPrice() == null ? "" : orderPO.getTradingPrice().toString());
      orderVO.setPayablePrice(
          orderPO.getPayablePrice() == null ? "" : orderPO.getPayablePrice().toString());
      orderVO.setScore(orderPO.getScore() == null ? "" : orderPO.getScore().toString());
      orderVO.setEmployeePhone(orderPO.getEmployeePhone());
      orderVO.setEmployeeName(orderPO.getEmployeeName());
      String appointStartTime = dateToString(orderPO.getAppointmentStartTime(), format);
      orderVO.setAppointmentStartTime(appointStartTime);
      String appointEndTime = dateToString(orderPO.getAppointmentEndTime(), format);
      orderVO.setAppointmentEndTime(appointEndTime);
      orderVO.setTotalQuantity(
          orderPO.getTotalQuantity() == null ? "" : orderPO.getTotalQuantity().toString());
      String signTime = dateToString(orderPO.getSignTime(), format);
      orderVO.setSignTime(signTime);
      orderVOS.add(orderVO);
    }
    return new PageVO<OrderVO>(page).setList(orderVOS);
  }

  /**
   * 更新订单信息
   * @return 成功失败msg
   */
  @Override
  public String updateOrder(OrderCondition orderCondition) {
    log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
        "OrderServiceImpl",
        "updateOrder",
        JSON.toJSONString(orderCondition)));

    //设置时间格式
    String format = "yyyy-MM-dd HH:mm:ss";
    OrderPO orderPO = new OrderPO();
    orderPO.setId(orderCondition.getId());
    orderPO.setOrderType(orderCondition.getOrderType());
    orderPO.setOrderStatus(orderCondition.getOrderStatus());
    orderPO.setDeliveryType(orderCondition.getDeliveryType());
    orderPO.setTradingPrice(orderCondition.getTradingPrice());
    orderPO.setPayablePrice(orderCondition.getPayablePrice());
    orderPO.setScore(orderCondition.getScore());
    Date signTime = stringToDate(orderCondition.getSignTime(), format);
    orderPO.setSignTime(signTime);

    int result = orderMapper.updateOrder(orderPO);
    String msg = null;
    if (result > 0) {
      msg = ResultErrorCodeEnum.SUCCESS.getMessage();
    } else {
      msg = ResultErrorCodeEnum.FAILURE.getMessage();
    }

    return msg;
  }

  /**
   * 插入订单
   * @return 成功失败msg
   */

  @Override
  public String insertOrder(OrderCondition orderCondition) {
    log.info(String.format(LogConstants.LOG_INFO_CLASS_FUNC_PARAM,
        "OrderServiceImpl",
        "insertOrder",
        JSON.toJSONString(orderCondition)));

    //设置日期格式
    String format = "yyyy-MM-dd HH:mm:ss";
    OrderPO orderPO = new OrderPO();
    //订单Id随机生成
    orderPO.setId("1234");
    orderPO.setOrderSn(orderCondition.getOrderSn());
    orderPO.setGroupId(orderCondition.getGroupId());
    orderPO.setOrderType(orderCondition.getOrderType());
    orderPO.setBusinessModelId(orderCondition.getBusinessModelId());
    orderPO.setCustomerId(orderCondition.getCustomerId());
    orderPO.setOrderAddressId(orderCondition.getOrderAddressId());
    orderPO.setStoreId(orderCondition.getStoreId());
    orderPO.setEshopId(orderCondition.getEshopId());
    orderPO.setOrderStatus(orderCondition.getOrderStatus());
    orderPO.setOrderSource(orderCondition.getOrderSource());
    orderPO.setInvoiceStatus(orderCondition.getInvoiceStatus());
    orderPO.setBuyerRemark(orderCondition.getBuyerRemark());
    orderPO.setSellerRemark(orderCondition.getSellerRemark());
    orderPO.setEmployeeRemark(orderCondition.getEmployeeRemark());
    orderPO.setStoreRemark(orderCondition.getStoreRemark());
    orderPO.setAbnormalType(orderCondition.getAbnormalType());
    orderPO.setAbnormalRemark(orderCondition.getAbnormalRemark());
    orderPO.setDeliveryType(orderCondition.getDeliveryType());
    orderPO.setTradingPrice(orderCondition.getTradingPrice());
    orderPO.setPayablePrice(orderCondition.getPayablePrice());
    orderPO.setScore(orderCondition.getScore());
    orderPO.setIsSplit(orderCondition.getIsSplit());
    orderPO.setEmployeeId(orderCondition.getEmployeeId());
    orderPO.setEmployeePhone(orderCondition.getEmployeePhone());
    orderPO.setEmployeeName(orderCondition.getEmployeeName());
    orderPO.setAppointmentStartTime(stringToDate(orderCondition.getAppointmentStartTime(), format));
    orderPO.setAppointmentEndTime(stringToDate(orderCondition.getAppointmentEndTime(), format));
    orderPO.setEshopComboProId(orderCondition.getEshopComboProId());
    orderPO.setExpiryDate(stringToDate(orderCondition.getExpiryDate(), format));
    orderPO.setComboPrice(orderCondition.getComboPrice());
    orderPO.setTotalQuantity(orderCondition.getTotalQuantity());
    orderPO.setGrouponInstanceId(orderCondition.getGrouponInstanceId());
    orderPO.setOrderSnReserve(orderCondition.getOrderSnReserve());
    orderPO.setNormalStoreId(orderCondition.getNormalStoreId());
    orderPO.setThirdPart(orderCondition.getThirdPart());
    orderPO.setSignTime(stringToDate(orderCondition.getSignTime(), format));
    orderPO.setCreateUserId(orderCondition.getCreateUserId());
    orderPO.setCreateUser(orderCondition.getCreateUser());

    String msg = "";
    int result = orderMapper.insertOrder(orderPO);
    if (result > 0) {
      msg = ResultErrorCodeEnum.SUCCESS.getMessage();
    } else {
      msg = ResultErrorCodeEnum.FAILURE.getMessage();
    }
    return msg;
  }

  /**
   * 根据订单Id删除订单
   * @return 成功失败信息
   */
  @Override
  public String deleteById(OrderCondition orderCondition) {
    String msg = "";
    int result = orderMapper.deleteById(orderCondition.getId());
    if (result > 0) {
      msg = ResultErrorCodeEnum.SUCCESS.getMessage();
    } else {
      msg = ResultErrorCodeEnum.FAILURE.getMessage();
    }
    return msg;
  }

  /**
   * 日期转化字符串方法
   */
  private static String dateToString(Date date, String format) {
    String dateString = "";
    if (date != null) {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      dateString = formatter.format(date);
    }
    return dateString;
  }


  /**
   * 字符串转日期方法
   */
  private static Date stringToDate(String time, String format) {
    Date strToDate = null;
    if (time != null) {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      try {
        strToDate = formatter.parse(time);
      } catch (ParseException e) {
        log.error("format error!", e);
      }
    }
    return strToDate;
  }
}
