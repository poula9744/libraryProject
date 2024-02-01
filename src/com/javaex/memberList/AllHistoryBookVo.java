package com.javaex.memberList;

public class AllHistoryBookVo {

	private String title;
	private String author;
	private String pubs;
	private String pubDate;
	private String bookRent;
	private String bookReturn;
	private String memberId;
	
	
	public AllHistoryBookVo(String title, String author, String pubs, String pubDate, String bookRent,
			String bookReturn) {
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.bookRent = bookRent;
		this.bookReturn = bookReturn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getBookRent() {
		return bookRent;
	}

	public void setBookRent(String bookRent) {
		this.bookRent = bookRent;
	}

	public String getBookReturn() {
		return bookReturn;
	}

	public void setBookReturn(String bookReturn) {
		this.bookReturn = bookReturn;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	
}
