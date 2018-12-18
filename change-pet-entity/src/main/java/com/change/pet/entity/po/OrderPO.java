package com.change.pet.entity.po;

import com.change.pet.common.base.BasePO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/13 10:18
 */

@Data
public class OrderPO extends BasePO {

  @ApiModelProperty(value = "订单ID", position = 1)
  private String id;

  @ApiModelProperty(value = "订单编号", position = 2)
  private String orderSn;

  @ApiModelProperty(value = "组合订单ID", position = 3)
  private String groupId;

  @ApiModelProperty(value = "订单类型", position = 4)
  private String orderType;

  @ApiModelProperty(value = "业务模式", position = 5)
  private String businessModelId;

  @ApiModelProperty(value = "客户ID", position = 6)
  private String customerId;

  @ApiModelProperty(value = "订单收货地址ID", position = 7)
  private String orderAddressId;

  @ApiModelProperty(value = "门店ID", position = 8)
  private String storeId;

  @ApiModelProperty(value = "E店ID", position = 9)
  private String eshopId;

  @ApiModelProperty(value = "订单状态", position = 10)
  private String orderStatus;

  @ApiModelProperty(value = "订单来源", position = 11)
  private String orderSource;

  @ApiModelProperty(value = "发票状态", position = 12)
  private String invoiceStatus;

  @ApiModelProperty(value = "买家备注", position = 13)
  private String buyerRemark;

  @ApiModelProperty(value = "卖家备注", position = 14)
  private String sellerRemark;

  @ApiModelProperty(value = "国安侠备注", position = 15)
  private String employeeRemark;

  @ApiModelProperty(value = "门店备注", position = 16)
  private String storeRemark;

  @ApiModelProperty(value = "异常状态", position = 17)
  private String abnormalType;

  @ApiModelProperty(value = "异常备注", position = 18)
  private String abnormalRemark;

  @ApiModelProperty(value = "配送方式", position = 19)
  private String deliveryType;

  @ApiModelProperty(value = "交易价格(多)", position = 20)
  private Double tradingPrice;

  @ApiModelProperty(value = "应付金额(少)", position = 21)
  private Double payablePrice;

  @ApiModelProperty(value = "积分", position = 23)
  private Integer score;

  @ApiModelProperty(value = "是否被拆订单", position = 24)
  private String isSplit;

  @ApiModelProperty(value = "员工ID", position = 25)
  private String employeeId;

  @ApiModelProperty(value = "员工电话", position = 26)
  private String employeePhone;

  @ApiModelProperty(value = "员工姓名", position = 27)
  private String employeeName;

  @ApiModelProperty(value = "预约开始时间", position = 28)
  private Date appointmentStartTime;

  @ApiModelProperty(value = "预约结束时间", position = 29)
  private Date appointmentEndTime;

  @ApiModelProperty(value = "E店组合商品ID", position = 30)
  private String eshopComboProId;

  @ApiModelProperty(value = "有效期限", position = 31)
  private Date expiryDate;

  @ApiModelProperty(value = "组合商品价格", position = 32)
  private Double comboPrice;

  @ApiModelProperty(value = "总数量", position = 33)
  private Integer totalQuantity;

  @ApiModelProperty(value = "团购实例ID", position = 34)
  private String grouponInstanceId;

  @ApiModelProperty(value = "订单编号反转", position = 43)
  private String orderSnReserve;

  @ApiModelProperty(value = "所属门店ID", position = 44)
  private String normalStoreId;

  @ApiModelProperty(value = "第三方code", position = 45)
  private String thirdPart;

  @ApiModelProperty(value = "订单签收时间", position = 46)
  private Date signTime;

}
