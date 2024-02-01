package com.javaex.memberList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryDao {

	Scanner sc = new Scanner(System.in);

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/library_db";
	private String id = "manager";
	private String pw = "book";

	// 생성자

	// 메소드 g/s

	// 메소드 일반

	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);

		} catch (SQLException e) {
			System.out.println("error:" + e);

		}

	}// getConnection()

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}// close()

	// 책 리스트(대여정보까지)
	public List<HistoryVo> historyList(int menu) {

		this.getConnection();

		// 리스트 준비

		List<HistoryVo> historyList = new ArrayList<HistoryVo>();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = "";
			
			if (menu == 1) {
				
				query = "";
				query += " select   book_id,  ";
				query += " 			title,  ";
				query += " 			pubs,  ";
				query += " 			pub_date,  ";
				query += " 			author,  ";
				query += " 			if(rent_status = 1, '대여가능', '대여중') as rent_status  ";
				query += " from book ";
				
			}
			/*
			if (menu == 2) {
				System.out.println("*************************");
				System.out.println("[검색할 키워드를 입력하세요]");
				System.out.print("> ");
				String search = sc.nextLine();
				System.out.println("*************************");
				query = "";
				query += " select   book_id,  ";
				query += " 			title,  ";
				query += " 			pubs,  ";
				query += " 			pub_date,  ";
				query += " 			author,  ";
				query += " 			if(rent_status = 1, '대여가능', '대여중') as rent_status  ";
				query += " from book ";
				query += " where book_id like '%" + search + "%'";
				query += " or title like '%" + search + "%'";
				query += "  or pubs like '%" + search + "%'";
				query += "  or author like '%" + search + "%'";
			}
			*/
			else if (menu == 3) {
				query = "";
				query += " select   book_id,  ";
				query += " 			title,  ";
				query += " 			pubs,  ";
				query += " 			pub_date,  ";
				query += " 			author,  ";
				query += " 			if(rent_status = 1, '대여가능', '대여중') as rent_status  ";
				query += " from book ";
				query += " where rent_status = '대여중' ";
			}

			// -바인딩
			pstmt = conn.prepareStatement(query);

			// -실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				String author = rs.getString("author");
				String rentStatus = rs.getString("rent_status");

				HistoryVo historyVo = new HistoryVo(bookId, title, pubs, pubDate, author, rentStatus);

				historyList.add(historyVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
		return historyList;
	}// historyList()

	// 대여 등록
	// historyDao.rentInsert(1,1);
	public int rentInsert(int memberno, int bookId) {
		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비(insert + update)
			String query = "";
			query += " insert into history ";
			query += " values(null, now(), null, ?, ?) ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberno);
			pstmt.setInt(2, bookId);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 대여되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return count;
	}// rentInsert

	// rentStatus 업데이트

	public int rentUpdate(int rentStatus) {
		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비(insert + update)
			String query = "";
			query += " update   book ";
			query += " set    	rent_status = 0 ";
			query += " where book_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rentStatus);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return count;

	}// rentUpdate

	// 반납 등록
	// historyDao.returnInsert()
	public int returnInsert(int memberNo, int bookId) {
		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비
			String query = "";
			query += " insert into history ";
			query += " values(null, null, now(), ?, ?) ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, bookId);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 반납되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return count;
	}// returnInsert

	// 반납 업데이트
	public int returnUpdate(int rentStatus) {
		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비(insert + update)
			String query = "";
			query += " update   book ";
			query += " set    	rent_status = 1 ";
			query += " where book_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rentStatus);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리

			System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return count;

	}// returnUpdate

	public void search() { // 검색

		this.getConnection();

		// 리스트 준비

		List<HistoryVo> hList = new ArrayList<HistoryVo>();

		try {
			System.out.println("*************************");
			System.out.println("[검색할 키워드를 입력하세요]");
			System.out.print("> ");
			String search = sc.nextLine();
			System.out.println("*************************");

			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = "";
			query += " select   book_id,  ";
			query += " 			title,  ";
			query += " 			pubs,  ";
			query += " 			author  ";
			query += " from book ";
			query += " where book_id like '%" + search + "%'";
			query += " or title like '%" + search + "%'";
			query += "  or pubs like '%" + search + "%'";
			query += "  or author like '%" + search + "%'";

			// -바인딩
			pstmt = conn.prepareStatement(query);

			// -실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String author = rs.getString("author");

				HistoryVo historyVo = new HistoryVo(bookId, title, pubs, author);

				hList.add(historyVo);

			}
			// 4.결과처리
			for (HistoryVo historyVo : hList) {
				int bookId = historyVo.getHistoryNo();
				String title = historyVo.getTitle();
				String pubs = historyVo.getPubs();
				String author = historyVo.getAuthor();

				System.out.println("책 아이디: " + bookId + "책 제목: " + title + "출판사: " + pubs + "작가: " + author);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
	}

}
