package com.javaex.memberList;

public class HistoryVo {
	
	//필드
	private int historyNo;
	private int memberNo;
	private String rent;
	private String bookreturn;
	private int bookId;
	private String title;
	private String author;
	private String pubs;
	private String pubDate;
	private String rentStatus; 
	
	
	//생성자
	
	//디폴트 생성자
	public HistoryVo() {
		
	}
	
	//등록용 생성자
	
	
	public HistoryVo(int historyNo, String rent, String bookreturn, int memberNo, int bookId) {
		super();
		this.historyNo = historyNo;
		this.memberNo = memberNo;
		this.bookId = bookId;
		this.rent = rent;
		this.bookreturn = bookreturn;
		
	}
	
	public HistoryVo(int bookId, String title, String pubs, String author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.author = author;
	}

	//리스트용 생성자
	public HistoryVo(int bookId, String title, String pubs, String pubDate, String author, String rentStatus ) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.author = author;
		this.rentStatus = rentStatus;
				
	}
	
	//전체 생성자
	
	public HistoryVo(int historyNo, int memberNo, String rent, String bookreturn, int bookId, String title,
			String author, String pubs, String pubDate, String rentStatus) {
		super();
		this.historyNo = historyNo;
		this.memberNo = memberNo;
		this.rent = rent;
		this.bookreturn = bookreturn;
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.pubs = pubs;
		this.pubDate = pubDate;
		this.rentStatus = rentStatus;
	}

	
	
	//메소드 g/s
	
	
	
	public int getHistoryNo() {
		return historyNo;
	}
	
	public String getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
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

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getBookreturn() {
		return bookreturn;
	}
	public void setBookreturn(String bookreturn) {
		this.bookreturn = bookreturn;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubs() {
		return pubs;
	}
	public void setPub(String pubs) {
		this.pubs = pubs;
	}
	
	//메소드 일반
	@Override
	public String toString() {
		return "HistoryVo [historyNo=" + historyNo + ", memberId=" + memberNo + ", rent=" + rent + ", bookreturn="
				+ bookreturn + ", bookId=" + bookId + ", title=" + title + ", author=" + author + ", pub=" + pubs + "]";
	}
}
