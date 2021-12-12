
package restaurant.reviewManagement.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import restaurant.reviewManagement.service.ReviewDefaultVO;

public class ReviewVO extends ReviewDefaultVO {

	private static final long serialVersionUID = 1L;

	/** 아이디 */
	private int id;

	/** 이름 */
	private int userId;

	/** 내용 */
	private int shopId;

	/** 사용여부 */
	private int orderId;

	/** 등록자 */
	private float star;
	
	private String title;
	
	private String content;
	
	private String image;
	
	private boolean ceoReco;
	
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getStar() {
		return star;
	}

	public void setStar(float star) {
		this.star = star;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public boolean getCeoReco() {
		return ceoReco;
	}
	
	public void setCeoReco(boolean ceoReco) {
		this.ceoReco = ceoReco;
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

