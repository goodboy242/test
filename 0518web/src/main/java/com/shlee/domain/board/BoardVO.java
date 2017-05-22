package com.shlee.domain.board;

public class BoardVO {

	private String bidx;
	private String title;
	private String contents;
	private String userId;
	private String hitcnt;
	private String writedate;

	@Override
	public String toString() {
//		if(contents==null||contents.isEmpty()){
//			return "BoardVO [bidx=" + bidx + ", title=" + title  + ", userId=" + userId
//					+ ", hitcnt=" + hitcnt + ", writedate=" + writedate + "]";
//		}
		
		return "BoardVO [bidx=" + bidx + ", title=" + title + ", contents=" + contents + ", userId=" + userId
				+ ", hitcnt=" + hitcnt + ", writedate=" + writedate + "]";
	}

	public String getBidx() {
		return bidx;
	}

	public void setBidx(String bidx) {
		this.bidx = bidx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHitcnt() {
		return hitcnt;
	}

	public void setHitcnt(String hitcnt) {
		this.hitcnt = hitcnt;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

}
