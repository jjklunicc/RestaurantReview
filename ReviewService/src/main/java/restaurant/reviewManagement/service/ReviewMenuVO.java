package restaurant.reviewManagement.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReviewMenuVO extends ReviewMenuDefaultVO {

	private static final long serialVersionUID = 1L;

	/** 아이디 */
	private int id;

	/** 이름 */
	private int reviewId;

	/** 내용 */
	private int menuId;

	/** 사용여부 */
	private boolean like;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public boolean getLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}

