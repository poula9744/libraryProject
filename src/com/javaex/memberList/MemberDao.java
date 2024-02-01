package com.javaex.memberList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDao {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String id = "manager";
	private String pw = "book";

	Scanner sc = new Scanner(System.in);
	// 생성자
	// 기본 생성자 사용

	// 메소드

	// 메소드 - 일반
	private void getConnection() {

		// 0. import java.sql.*;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/library_db";
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

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
	}

	/////////////////////////////////////////////////////////
	// 회원 리스트
	public List<MemberVo> memberList() {

		// 리스트 준비
		List<MemberVo> memberList = new ArrayList<MemberVo>();

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " select  member_no ";
			query += "        ,member_name ";
			query += "        ,phone_number ";
			query += "        ,address ";
			query += "        ,age ";
			query += "        ,member_id ";
			query += "        ,member_pw ";
			query += " from Membership ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {
				int no = rs.getInt("member_no");
				String name = rs.getString("member_name");
				String phoneNumber = rs.getString("phone_number");
				String address = rs.getString("address");
				int age = rs.getInt("age");
				String id = rs.getString("member_id");
				String pw = rs.getString("member_pw");

				// Vo로 묶기
				MemberVo vo = new MemberVo(no, name, phoneNumber, address, age, id, pw);

				// 리스트에 추가
				memberList.add(vo);
			}

			// 4.결과처리

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return memberList;
	} // authorList()

	// 회원 정보 수정
	public void memberUpdate(MemberVo memberVo) {

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += " update membership ";
			query += " set  member_name = ?";
			query += "     ,phone_number = ?";
			query += "     ,address = ?";
			query += "     ,age = ?";
			query += "     ,member_pw = ?";
			query += " where member_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberVo.getMemberName());
			pstmt.setString(2, memberVo.getPhoneNumber());
			pstmt.setString(3, memberVo.getAddress());
			pstmt.setInt(4, memberVo.getAge());
			pstmt.setString(5, memberVo.getMemberPw());
			pstmt.setString(6, memberVo.getMemberId());

			// 실행
			pstmt.executeUpdate();

			System.out.println("[수정이 완료되었습니다]");

			// 4.결과처리
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

	}

	// 회원 삭제
	public int memberrDelete(int no) {

		int count = -1;

		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += "delete from membership ";
			query += " where member_no = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			// 실행
			pstmt.executeUpdate();

			System.out.println("[삭제되었습니다]");

			// 4.결과처리
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
		return count;

	}

	// 회원 등록
	public int memberInsert(String id, String pw, String name, String phoneNumber, String address, int age) {

		int count = -1;
		this.getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += "insert into membership ";
			query += " values(null, ?, ?, ?, ?, ?, ?)";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, address);
			pstmt.setInt(4, age);
			pstmt.setString(5, id);
			pstmt.setString(6, pw);

			// 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + " 건 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		this.close();
		return count;
	}

	// 회원 등록2
	public int memberInsert(MemberVo memberVo) {

		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = "";
			query += " insert into membership ";
			query += " values(null, ?, ?, ?, ?, ?, ? ) ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberVo.getMemberName());
			pstmt.setString(2, memberVo.getPhoneNumber());
			pstmt.setString(3, memberVo.getAddress());
			pstmt.setInt(4, memberVo.getAge());
			pstmt.setString(5, memberVo.getMemberId());
			pstmt.setString(6, memberVo.getMemberPw());

			// -실행
			pstmt.executeUpdate();

			// 4.결과처리
			System.out.println("[가입이 완료되었습니다]");

		} catch (SQLException e) {
			System.out.println("error:" + e);

		}

		this.close();

		return count;

	}

	// 로그인
	public int log(String id, String pw) {
		this.getConnection();

		try {

			String query = "";
			query += " select member_pw ";
			query += " from Membership ";
			query += " where member_id = ? ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return 1; // 로그인 완료

				} else {
					return 0; // 비밀번호 틀림
				}
			}
			return -1; // 아이디 없음

		} catch (SQLException e) {
			e.printStackTrace();

		}
		this.close();
		return -2; // 로그인 불가
	}

	public List<AllHistoryBookVo> aList() {

		List<AllHistoryBookVo> aList = new ArrayList<AllHistoryBookVo>();

		this.getConnection();
		try {
			System.out.println("*************************");
			System.out.println("[아이디를 입력해주세요]");
			System.out.print(">아이디: ");
			String memberId = sc.nextLine();
			System.out.println("*************************");

			// SQL문
			String query = "";
			query += " select title ";
			query += " 	      ,author ";
			query += "        ,pubs ";
			query += "        ,pub_date ";
			query += "        ,book_rent ";
			query += "        ,book_return";
			query += " from history h ";
			query += " left join book b ";
			query += " 	 on b.book_id = h.book_id";
			query += " left join (select member_no ";
			query += "            from membership";
			query += "            where member_id = ? ) s ";
			query += " 	on h.member_no = s.member_no ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);

			// 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				String bookRent = rs.getString("book_rent");
				String bookReturn = rs.getString("book_return");

				// Vo로 묶기
				AllHistoryBookVo vo = new AllHistoryBookVo(title, author, pubs, pubDate, bookRent, bookReturn);

				// 리스트에 추가
				aList.add(vo);

			}

			for (AllHistoryBookVo Vo : aList) {
				String title = Vo.getTitle();
				String author = Vo.getAuthor();
				String pubs = Vo.getPubs();
				String pubDate = Vo.getPubDate();
				String bookRent = Vo.getBookRent();
				String bookReturn = Vo.getBookReturn();

				System.out.print("책이름: " + title);
				System.out.print("  작가: " + author);
				System.out.print("  출판사: " + pubs);
				System.out.print("  출판일: " + pubDate);
				System.out.print("  대여날짜: " + bookRent);
				System.out.print("  대출날짜: " + bookReturn);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		this.close();
		return aList;
	}

	public void memberSearch() {

		this.getConnection();
		List<MemberVo> memberList = new ArrayList<MemberVo>();

		try {
			System.out.println("*************************");
			System.out.println("[검색할 키워드를 입력하세요]");
			System.out.print("> ");
			String search = sc.nextLine();
			System.out.println("*************************");

			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = "";
			query += " select member_no ";
			query += " 	   	,member_name ";
			query += " 	  	 ,phone_number ";
			query += "        ,address ";
			query += "        ,member_id ";
			query += " from membership ";
			query += " where member_name like  '%" + search +"%'" ;
			query += " or phone_number like '%" + search + "%'" ;
			query += "  or address like  '%" + search + "%'" ;
			query += " or member_id like  '%" + search + "%'";

			// -바인딩
			pstmt = conn.prepareStatement(query);

			// -실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {
				int no = rs.getInt("member_no");
				String name = rs.getString("member_name");
				String phoneNumber = rs.getString("phone_number");
				String address = rs.getString("address");
				String id = rs.getString("member_id");

				// Vo로 묶기
				MemberVo vo = new MemberVo(no, name, phoneNumber, address, id);

				// 리스트에 추가
				memberList.add(vo);
			}

			// 4.결과처리
			for(MemberVo memberVo : memberList) {
				int no = memberVo.getMemberNo();
				String name = memberVo.getMemberName();
				String phoneNumber = memberVo.getPhoneNumber();
				String address = memberVo.getAddress();
				String id = memberVo.getMemberId();
				
				System.out.println(no +"." + " 이름: " + name + "  전화번호: " + phoneNumber 
						           + "  주소: " + address + "  아이디: " + id);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);

		}

		this.close();

	}

}
