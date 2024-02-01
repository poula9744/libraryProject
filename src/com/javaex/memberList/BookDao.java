package com.javaex.memberList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	//필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String driver = "com.mysql.cj.jdbc.Driver" ;
	private String url = "jdbc:mysql://localhost:3306/library_db";
	private String id = "manager";
	private String pw = "book";
	
	
	//생성자
	
	
	//메소드 g/s
	
	
	
	//메소드 일반
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
		
	}//getConnection()
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
	}//close()
	
	
	
	//도서 추가
		public int bookInsert(String title, String pubs, String pubDate, String author) {
			int count = -1;
			
			this.getConnection();
			
			try {
				// 3. SQL문 준비 / 바인딩 / 실행
				//sql문 준비(insert + update)
				String query = "";
				query += " insert into book ";
				query += " values(null, ?, ?, ?, ?, 1) ";
				
				//바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, title);
				pstmt.setString(2, pubs);
				pstmt.setString(3, pubDate);
				pstmt.setString(4, author);
				
					
				//실행
				count = pstmt.executeUpdate();
					
				// 4.결과처리
					
				System.out.println(count + "권 추가되었습니다.");

				} catch (SQLException e) {
				    System.out.println("error:" + e);
				}   this.close();
					return count;
		}//bookInsert
	
		
		
	//도서 수정
		//rentStatus 업데이트
		
		public int bookUpdate(String title, String pubs, String pubDate, String author, int rentStatus, int bookId) {
			int count = -1;
			
			this.getConnection();
			
			try {
				// 3. SQL문 준비 / 바인딩 / 실행
				//sql문 준비(insert + update)
				String query = "";
				 query += " update  book ";
		         query += " set     title = ?, ";
		         query += " 		pubs = ?, ";
		         query += " 		pub_date = ?, ";
		         query += " 		author = ?, ";
		         query += " 		rent_status = ? ";
		         query += " where book_id = ? ";
	
				//바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, title);
				pstmt.setString(2, pubs);
				pstmt.setString(3, pubDate);
				pstmt.setString(4, author);
				pstmt.setInt(5, rentStatus);
				pstmt.setInt(6, bookId);
				
				//실행
				count = pstmt.executeUpdate();
					
				// 4.결과처리
					
				System.out.println(count + "건 수정되었습니다.");

				} catch (SQLException e) {
				    System.out.println("error:" + e);
				}   this.close();
					return count;
			
		}//bookUpdate
		
		
		// 작가삭제
				public int bookDelete(int bookId) {
					
					int count = -1;
				
					this.getConnection();
					
					try {
						
						// 3. SQL문 준비 / 바인딩 / 실행
						// -SQL문 준비
						String query = "";
						query += " delete from book ";
						query += " where book_id = ? ";
						
						// -바인딩
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, bookId);
						
						// -실행
						count = pstmt.executeUpdate();
						
						// 4.결과처리
						System.out.println(count + "건이 삭제되었습니다.");
						

					} catch (SQLException e) {
						System.out.println("error:" + e);
					} 
					
					this.close();

					return count;
				}//bookDelete()
				
			// 작가리스트
			public List<BookVo> bookList() {
					
				this.getConnection();
					
				//리스트준비
				List<BookVo> bookList = new ArrayList<BookVo>();

				try {
						
				// 3. SQL문 준비 / 바인딩 / 실행
				// -SQL문 준비
					String query = "";
					query += " select  book_id, ";
					query += "         title, ";
					query += "         pubs, ";
					query += "         pub_date, ";
					query += "         author ";
					query += " from book ";
						
					// -바인딩
					pstmt = conn.prepareStatement(query);
						
					// -실행
					rs = pstmt.executeQuery();
						
					// 4.결과처리
					while(rs.next()) {
						int bookId = rs.getInt("book_id");
						String title = rs.getString("title");
						String pubs = rs.getString("pubs");
						String pubDate = rs.getString("pub_date");
						String author = rs.getString("author");
							
						BookVo bookVo = new BookVo(bookId, title, pubs, pubDate, author);
							
						bookList.add(bookVo);
					}
						
				} catch (SQLException e) {
					    System.out.println("error:" + e);
				}
					
				this.close();

				return bookList;
					
			}//authorList()				
		

}
