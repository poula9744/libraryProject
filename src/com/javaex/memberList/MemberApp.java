package com.javaex.memberList;

import java.util.Scanner;

public class MemberApp {

	public static void main(String[] args) {
		
		MemberFunction m = new MemberFunction();
		Scanner sc = new Scanner(System.in);
		int num;
		
		try {
			System.out.println("***************************************");
			System.out.println("*             [asc library]           *");
			System.out.println("*                                     *");
			System.out.println("*              [환영합니다]           *");
			System.out.println("***************************************");
			
			while(true) {
				System.out.println("***************************************");
				System.out.println("*                 [회원]              *");
				System.out.println("*               1. 로그인             *");
				System.out.println("*               2. 회원가입           *");
				System.out.println("*               3. 종료               *");
				System.out.println("***************************************");
				System.out.print(">메뉴번호: ");
				num = sc.nextInt();
				sc.nextLine();
				
				switch(num) {
				case 1: 
					m.login();
					break;
					
				case 2: 
					m.register();
					break;
				
				case 3: 
					System.out.println("[종료합니다]");
					break;
					
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
		            break;
				
				}
				
				if(num==3) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
