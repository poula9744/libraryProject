package com.javaex.memberList;

public class BookVo {
	
	//필드
	private int bookId;
	private String title;
	private String pubs;
	private String pubDate;
	private String author;
	private int rentStatus;
	
	//생성자
	
	//디폴트 생성자
	public BookVo() {
		
	}
	
	//등록용 생성자
	public BookVo(int bookId, String title, String pubs, String pubDate, String author, int rentStatus) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.author = author;
		this.rentStatus = rentStatus;
	}

	public BookVo(int bookId, String title, String pubs, String pubDate, String author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.author = author;
	}

	//메소드 g/s
	
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(int rentStatus) {
		this.rentStatus = rentStatus;
	}

	//메소드 일반
	
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pubDate=" + pubDate + ", author="
				+ author + ", rentStatus=" + rentStatus + "]";
	}
	
	
	
}
