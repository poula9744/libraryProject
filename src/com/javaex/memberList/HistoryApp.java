package com.javaex.memberList;

import java.util.List;
import java.util.Scanner;

public class HistoryApp {

	public static void main(String[] args) {
		
		HistoryDao historyDao = new HistoryDao();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("***************************************");
			System.out.println("               [대여관리]              ");
			System.out.println("               1.책리스트              ");
			System.out.println("               2.대여등록              ");
			System.out.println("               3.반납등록              ");
			System.out.println("               4.종료                  ");
			System.out.println("***************************************");
			System.out.println("번호를 입력해주세요 : ");
			int num = sc.nextInt();
			System.out.println("***************************************");
			
			if(num == 1) {
				
				List<HistoryVo> historyList = historyDao.historyList(1);
					for(HistoryVo historyVo : historyList) {
						System.out.println(historyVo.getBookId()  + ". "
										 + historyVo.getTitle()   + ", "
										 + historyVo.getPubs()    + ", "
										 + historyVo.getPubDate() + ", "
										 + historyVo.getAuthor()  + ", "
										 + historyVo.getRentStatus());
				}
				
				System.out.println("검색 (책번호를 입력하세요) : ");
				int search = sc.nextInt();
				for(int i = 0; i < historyList.size(); i++) {
					if(historyList.get(i).getBookId() == search) {
						System.out.println(historyList.get(i).getBookId()  + ". "
								 + historyList.get(i).getTitle()   + ", "
								 + historyList.get(i).getPubs()    + ", "
								 + historyList.get(i).getPubDate() + ", "
								 + historyList.get(i).getAuthor()  + ", "
								 + historyList.get(i).getRentStatus());
					}
					continue;
				}
				
			}
			
			
			else if(num == 2) {
				System.out.println("              [대여등록]             ");
				System.out.println(">회원번호 : ");
				int memberNo = sc.nextInt();
				System.out.println(">책아이디 : ");
				int bookId = sc.nextInt();
				historyDao.rentInsert(memberNo,bookId);
				historyDao.rentUpdate(bookId);
				System.out.println("       [대여가 완료되었습니다]       ");
			}
			
			
			else if(num == 3) {
				System.out.println("              [반납등록]             ");
				System.out.println("         [대여중인 책 리스트]        ");
				
				List<HistoryVo> historyList = historyDao.historyList(3);
				for(HistoryVo historyVo : historyList) {
					
					System.out.println(historyVo.getBookId()  + ". "
							 + historyVo.getTitle()   + ", "
							 + historyVo.getPubs()    + ", "
							 + historyVo.getPubDate() + ", "
							 + historyVo.getAuthor()  + ", "
							 + historyVo.getRentStatus());
					}
				
				System.out.println(">회원번호 : ");
				int memberNo = sc.nextInt();		
				System.out.println(">책아이디 : ");
				int bookId = sc.nextInt();
				historyDao.returnInsert(memberNo, bookId);
				historyDao.returnUpdate(bookId);
				System.out.println("       [반납이 완료되었습니다]       ");
			}
			
			
			
			else if(num == 4) {
				System.out.println("***************************************");
				System.out.println("***************감사합니다**************");
				break;
			}
			
			
			
			else {
				System.out.println("잘못 누르셨습니다.");
			}
		}
		
		
		sc.close();
		
	}

}
