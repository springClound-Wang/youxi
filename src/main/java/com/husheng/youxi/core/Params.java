
/**
* itbooking系统平台<br/>
* com.itbooking.vo<br/>
* Params.java<br/>
* 创建人:mofeng <br/>
* 时间：2018年9月24日-上午12:59:47 <br/>
* 2018itbooking-版权所有<br/>
*/
package com.husheng.youxi.core;

/**
 * 
 * Params<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月24日-上午12:59:47 <br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class Params {

	private String sort = " create_time desc ";
	private Integer status;
	private Integer isDelete = 0;
	private Integer pageNo = 1;
	private Integer pageSize = 10;
	private String keyword;
	private Integer filterId;
	private Integer mark;
	private Integer coursetype;
	private Integer isPush;
	private Long userId;
	private Integer categoryId;
	private Integer courseId;
	private Integer chapterId;
	private Integer lessonId;
	private Integer blogId;
	private Integer orderId;
	private Integer itemId;

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getFilterId() {
		return filterId;
	}

	public void setFilterId(Integer filterId) {
		this.filterId = filterId;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Integer coursetype) {
		this.coursetype = coursetype;
	}

	public Integer getIsPush() {
		return isPush;
	}

	public void setIsPush(Integer isPush) {
		this.isPush = isPush;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

}
