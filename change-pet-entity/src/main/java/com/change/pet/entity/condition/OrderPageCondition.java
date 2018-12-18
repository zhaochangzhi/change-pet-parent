package com.change.pet.entity.condition;

import com.change.pet.common.page.PageCondition;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @author：houlili
 * @date 2018/12/13 13:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderPageCondition extends PageCondition{

  /**
   * 签收开始时间
   */

  private String signStartTime;

  /**
   * 签收结束时间
   */

  private String signEndTime;

}
