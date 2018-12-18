package com.change.pet.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/13 11:25
 */
@Data
public class OrderVO {



  @ApiModelProperty(value = "订单编号", position = 2)
  private String orderSn;

  @ApiModelProperty(value = "订单类型", position = 4)
  private String orderType;

  @ApiModelProperty(value = "订单状态", position = 10)
  private String orderStatus;

  @ApiModelProperty(value = "订单来源", position = 11)
  private String orderSource;

  @ApiModelProperty(value = "配送方式", position = 19)
  private String deliveryType;

  @ApiModelProperty(value = "交易价格(多)", position = 20)
  private String tradingPrice;

  @ApiModelProperty(value = "应付金额(少)", position = 21)
  private String payablePrice;

  @ApiModelProperty(value = "积分", position = 23)
  private String score;

  @ApiModelProperty(value = "员工电话", position = 26)
  private String employeePhone;

  @ApiModelProperty(value = "员工姓名", position = 27)
  private String employeeName;

  @ApiModelProperty(value = "预约开始时间", position = 28)
  private String appointmentStartTime;

  @ApiModelProperty(value = "预约结束时间", position = 29)
  private String appointmentEndTime;

  @ApiModelProperty(value = "总数量", position = 33)
  private String totalQuantity;

  @ApiModelProperty(value = "订单签收时间", position = 46)
  private String signTime;


}
