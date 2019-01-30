package com.change.pet.common.page;

import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhaochangzhi
 * @description 分页
 * @date 2018/9/20 15:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO<T> {

	/**
	 * 页码（第几页）
	 */
	private Integer pageNo;

	/**
	 * 页大小（每页多少条）
	 */
	private Integer pageSize;

	/**
	 * 总数
	 */
	private Long total;

	/**
	 * 列表数据
	 */
	private List list;

	public PageVO(Page page) {
		this.pageNo = page.getPageNum();
		this.pageSize = page.getPageSize();
		this.total = page.getTotal();
		this.list = page.getResult();
	}

	public PageVO<T> setList(List<T> list) {
		this.list = list;
		return this;
	}
}