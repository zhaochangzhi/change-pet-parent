package com.change.pet.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/14 10:12
 */
public enum OrderStatusEnum {

  waitpay("待支付"),
  ordered("已下单"),
  waitdispatch("待派单"),
  dispatch("派单中"),
  received("已接单"),
  started("已出发"),
  signed("已签收"),
  commented("已评价"),
  success("已成功"),
  cancel("已取消"),

  waitConfirm("待确认"),
  confirmFailure("确认失败"),

  receivedClothes("已收衣"),

  dirtyWashImported("脏衣入库"),
  dirtyWashExported("脏衣出库"),

  factoryImported("工厂入库"),
  factoryExported("工厂出库"),

  cleanWashImported("净衣入库"),
  cleanWashExported("净衣出库"),
  eshopShipmentsed("供货商已发货");

  /**
   * 备注信息
   */
  private final String desc;

  private OrderStatusEnum(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

  public static OrderStatusEnum getEnum(String name) {
    OrderStatusEnum[] array = values();

    for (int i = 0; i < array.length; ++i) {
      if (array[i].name().equalsIgnoreCase(name)) {
        return array[i];
      }
    }

    return null;
  }

  public static String getEnumDesc(String name) {
    OrderStatusEnum anEnum = getEnum(name);
    return anEnum != null ? anEnum.getDesc() : null;
  }

  public static List toList() {
    List list = new ArrayList();
    OrderStatusEnum[] var1 = values();
    int var2 = var1.length;

    for (int var3 = 0; var3 < var2; ++var3) {
      OrderStatusEnum orderStatusEnum = var1[var3];
      Map<String, String> map = new HashMap();
      map.put("value", orderStatusEnum.name());
      map.put("desc", orderStatusEnum.getDesc());
      list.add(map);
    }

    return list;
  }

  public static Map<String, String> toMap() {
    OrderStatusEnum[] ary = values();
    Map<String, String> enumMap = new HashMap();

    for (int num = 0; num < ary.length; ++num) {
      enumMap.put(ary[num].name(), ary[num].getDesc());
    }

    return enumMap;
  }
}
