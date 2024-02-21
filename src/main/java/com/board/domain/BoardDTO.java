package com.board.domain;

public class BoardDTO extends CommonDTO {
	
	private Long idx;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private String noticeYn;
	private String secretYn;
	
	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", viewCnt=" + viewCnt + ", noticeYn=" + noticeYn + ", secretYn=" + secretYn + "]";
	}
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getNoticeYn() {
		return noticeYn;
	}
	public void setNoticeYn(String noticeYn) {
		this.noticeYn = noticeYn;
	}
	public String getSecretYn() {
		return secretYn;
	}
	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
	}
	
}
