package com.change.pet.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/14 10:11
 */
public enum OrderTypeEnum {

  product("商品"),
  service("服务"),
  appointment("预约");
  private final String desc;

  private OrderTypeEnum(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return this.desc;
  }

  public static OrderTypeEnum getEnum(String name) {
    OrderTypeEnum[] array = values();

    for (int i = 0; i < array.length; ++i) {
      if (array[i].name().equalsIgnoreCase(name)) {
        return array[i];
      }
    }

    return null;
  }

  public static String getEnumDesc(String name) {
    OrderTypeEnum anEnum = getEnum(name);
    return anEnum != null ? anEnum.getDesc() : null;
  }

  public static List toList() {
    List list = new ArrayList();
    OrderTypeEnum[] var1 = values();
    int var2 = var1.length;

    for (int var3 = 0; var3 < var2; ++var3) {
      OrderTypeEnum orderTypeEnum = var1[var3];
      Map<String, String> map = new HashMap();
      map.put("value", orderTypeEnum.name());
      map.put("desc", orderTypeEnum.getDesc());
      list.add(map);
    }

    return list;
  }

  public static Map<String, String> toMap() {
    OrderTypeEnum[] ary = values();
    Map<String, String> enumMap = new HashMap();

    for (int num = 0; num < ary.length; ++num) {
      enumMap.put(ary[num].name(), ary[num].getDesc());
    }

    return enumMap;
  }

}
