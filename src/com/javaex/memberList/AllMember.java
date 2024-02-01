package com.javaex.memberList;

import java.util.Scanner;

public class AllMember {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MemberFunction m = new MemberFunction();
		MemberDao memberDao = new MemberDao();
		int num;
		
		
		
		
		while(true) {
			System.out.println("**************************");
			System.out.println("*     [전체회원리스트]    *");
			System.out.println("*       1. 보기          *");
			System.out.println("*       2. 수정          *");
			System.out.println("*       3. 추가          *");
			System.out.println("*       4. 삭제          *");
			System.out.println("*       5. 검색          *");
			System.out.println("*       6. 종료          *");
			System.out.println("*************************");
			System.out.print(">메뉴번호: ");
			num = sc.nextInt();
			sc.nextLine();
			
			
			switch(num) {
			case 1:
				m.memberShow(); //리스트 출력
				break;
			case 2:
				m.update(); //수정
				break;
			case 3:
				m.memberPlus(); //추가
				break;
			case 4:
				m.memberOut(); //삭제
				break;
			case 5:
				memberDao.memberSearch(); //검색
				break;
			case 6:
				System.out.println("[종료합니다]");
				break;
			
			}
			if(num == 6) {
				break;
			}
		}
		
		

	}
	

}
