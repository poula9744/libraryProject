package com.javaex.memberList;

import java.util.List;
import java.util.Scanner;

public class MemberFunction {

	private Scanner sc = new Scanner(System.in);
	private String id, pw, name, phone, address, search;
	private int age, no, num;
	
	
	public void register() {
		
		try {
			System.out.println("***************************************");
			System.out.println("       [회원가입]      ");
			System.out.print(">이름: ");
			name = sc.nextLine();
			System.out.print(">전화번호: ");
			phone = sc.nextLine();
			System.out.print(">주소: ");
			address = sc.nextLine();
			System.out.print(">나이: ");
			age = sc.nextInt();
			sc.nextLine();
			System.out.print(">아이디: ");
			id = sc.nextLine();
			System.out.print(">비밀번호: ");
			pw = sc.nextLine();
			System.out.println("***************************************");
			
			MemberDao memberDao = new MemberDao();
			
			MemberVo memberVo = new MemberVo(name, phone, address, age, id, pw);
			memberDao.memberInsert(memberVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void login() {
		
		System.out.println("***************************************");
		System.out.println("                [로그인]               ");
		System.out.print(">ID: ");
		id = sc.nextLine();
		System.out.print(">PW: ");
		pw = sc.nextLine();
		System.out.println("***************************************");
		
		MemberDao memberDao = new MemberDao();
		int tf = memberDao.log(id, pw);
		
		if(tf == 1) {
			System.out.println("[로그인이 완료되었습니다]");
			next();
			
		} else if (tf == 0) {
			System.out.println("[비밀번호가 일치하지 않습니다]");
		} else if (tf == -1) {
			System.out.println("[아이디가 존재하지 않습니다]");
		} else {
			System.out.println("[로그인 할 수 없습니다]");
		}
		
	}
	
	public void next() {
		
		while(true) {
			
			System.out.println("***************************************");
			System.out.println("*               [메뉴]                *");
			System.out.println("*          1. 회원 정보 수정          *");
			System.out.println("*          2. 대여반납히스토리        *");
			System.out.println("*          3. 종료                    *");
			System.out.println("***************************************");
			
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1: 
				update();
				break;
				
			case 2: 
				MemberDao memberDao = new MemberDao();
				List<AllHistoryBookVo> aList= memberDao.aList();
				break;
				
			
			case 3: 
				System.out.println("[종료합니다]");
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
	            break;
			
			}
			if(num == 3) {
				break;
			}
		}
		
	}
	
	public void update() {
		System.out.println("***************************************");
		System.out.println("         [아이디를 입력해주세요]       ");
		System.out.print(">아이디: ");
		id = sc.nextLine();
		System.out.println("***************************************");
		
		
		System.out.println("***************************************");
		System.out.println("            [회원 정보 수정]           ");
		System.out.print(">이름: ");
		name = sc.nextLine();
		System.out.print(">전화번호: ");
		phone = sc.nextLine();
		System.out.print(">주소: ");
		address = sc.nextLine();
		System.out.print(">나이: ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print(">비밀번호: ");
		pw = sc.nextLine();
		System.out.println("***************************************");
		
		MemberDao memberDao = new MemberDao();
		
		MemberVo memberVo = new MemberVo(name, phone, address, age, pw, id);
		memberDao.memberUpdate(memberVo);
		
	}
	
	public void rrHistory() {
		
		
	}
	
	public void memberShow() {

		MemberDao memberDao = new MemberDao();
		List<MemberVo> memberList= memberDao.memberList();
		
		for (MemberVo memberVo : memberList) {
			int no = memberVo.getMemberNo();
			String name = memberVo.getMemberName();
			String phoneNumber = memberVo.getPhoneNumber();
			String address = memberVo.getAddress();
			int age = memberVo.getAge();
			String id = memberVo.getMemberId();
			String pw = memberVo.getMemberPw();

			System.out.print(no + ".");
			System.out.print("이름: " + name);
			System.out.print("  전화번호: " + phoneNumber);
			System.out.print("  주소: " + address);
			System.out.print("\t나이: " + age);
			System.out.print("  아이디: " + id);
			System.out.print("  비밀번호: " + pw);
			System.out.println();
		}
		System.out.println();
		System.out.println(memberList.size() + "명의 정보가 등록되어 있습니다.");
	}
	
	
	public void memberPlus() {
		
		try {
			System.out.println("***************************************");
			System.out.println("               [회원추가]              ");
			System.out.print(">이름: ");
			name = sc.nextLine();
			System.out.print(">전화번호: ");
			phone = sc.nextLine();
			System.out.print(">주소: ");
			address = sc.nextLine();
			System.out.print(">나이: ");
			age = sc.nextInt();
			sc.nextLine();
			System.out.print(">아이디: ");
			id = sc.nextLine();
			System.out.print(">비밀번호: ");
			pw = sc.nextLine();
			System.out.println("***************************************");
			
			MemberDao memberDao = new MemberDao();
			
			MemberVo memberVo = new MemberVo(name, phone, address, age, id, pw);
			memberDao.memberInsert(memberVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void memberOut() {
		System.out.println("***************************************");
		System.out.println("   [삭제할 회원의 넘버를 입력하세요]   ");
		System.out.print(">member_no: ");
		no = sc.nextInt();
		System.out.println("***************************************");
		
		MemberDao memberDao = new MemberDao();
		memberDao.memberrDelete(no);
		
	}
	
	public void memberSearch() {
		

		
		
			
			 
	}
	
	
	

	}
	

