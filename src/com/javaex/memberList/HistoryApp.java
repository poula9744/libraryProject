package com.javaex.memberList;

import java.util.List;
import java.util.Scanner;

public class HistoryApp {

	public static void main(String[] args) {
		
		HistoryDao historyDao = new HistoryDao();
		BookDao bookDao = new BookDao();
		MemberFunction m = new MemberFunction();
		MemberDao memberDao = new MemberDao();
		int number;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("***************************************");
			System.out.println("                                       ");
			System.out.println("*             [asc Library]           *");
			System.out.println("*                                     *");
			System.out.println("*               [관리자]              *");
			System.out.println("***************************************");
			System.out.println("                                       ");
			System.out.println("                 [메뉴]                ");
			System.out.println("              1. 대여관리              ");
			System.out.println("              2. 회원관리              ");
			System.out.println("              3. 책관리                ");
			System.out.println("              4. 종료                  ");
			System.out.println("                                       ");
			System.out.println("***************************************");
			System.out.print("번호를 입력해주세요 : ");
			int no = sc.nextInt();
			
			
				if(no==1) {
				while(true) {
					System.out.println("***************************************");
					System.out.println("               [대여관리]              ");
					System.out.println("               1.책리스트              ");
					System.out.println("               2.대여등록              ");
					System.out.println("               3.반납등록              ");
					System.out.println("               4.종료                  ");
					System.out.println("***************************************");
					System.out.print("번호를 입력해주세요 : ");
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
						/*
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
						*/
						
					}
					
					
					else if(num == 2) {
						System.out.println("              [대여등록]             ");
						System.out.print(">회원번호 : ");
						int memberNo = sc.nextInt();
						System.out.print(">책아이디 : ");
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
						
						System.out.print(">회원번호 : ");
						int memberNo = sc.nextInt();		
						System.out.print(">책아이디 : ");
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
						System.out.println("다시 입력해주세요");
		
					}
				}
				
				
				
				}//1번 대여관리
			if(no == 2) {
				while(true) {
					System.out.println("***************************************");
					System.out.println("*            [전체회원리스트]         *");
					System.out.println("*              1. 보기                *");
					System.out.println("*              2. 수정                *");
					System.out.println("*              3. 추가                *");
					System.out.println("*              4. 삭제                *");
					System.out.println("*              5. 검색                *");
					System.out.println("*              6. 종료                *");
					System.out.println("***************************************");
					System.out.print(">메뉴번호: ");
					number = sc.nextInt();
					sc.nextLine();
					
					
					switch(number) {
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
					if(number == 6) {
						break;
					}
				}
				
				
				
			}//2번 회원관리
				
				if(no == 3) {
					while(true) {
	
						System.out.println("***************************************");
						System.out.println("                 1. 추가               ");
						System.out.println("                 2. 수정               ");
						System.out.println("                 3. 삭제               ");
						System.out.println("                 4. 리스트             ");
						System.out.println("                 5. 종료               ");
						System.out.println("***************************************");
						System.out.print("번호를 입력해주세요");
						int num = sc.nextInt();
						System.out.println("***************************************");
	
						sc.nextLine();
	
						if (num == 5) {
							
							System.out.println("종료하겠습니다");
							break;
							
						}else if (num == 1) {
							System.out.println("           [책관리:추가]           ");
							System.out.print(">책제목:");
							String title = sc.nextLine();
							
							System.out.print(">출판사:");
							String pub = sc.nextLine();
							
							System.out.print(">출판일:");
							String pub_date = sc.nextLine();
							
							System.out.print(">작가:");
							String author = sc.nextLine();
							
							bookDao.bookInsert(title, pub, pub_date, author);
							
							System.out.println("          [책이 추가되었습니다]        ");
							System.out.println("***************************************");
						}else if (num == 2 ) {
							System.out.println("         [책관리:수정]       ");
							
							System.out.print(">책제목:");
							String title = sc.nextLine();
							
							System.out.print(">출판사:");
							String pub = sc.nextLine();
							
							System.out.print(">출판일:");
							String pubDate = sc.nextLine();
							
							System.out.print(">작가:");
							String author = sc.nextLine();
							
							System.out.print(">대여상태:");
							int rentStatus = sc.nextInt();
							
							System.out.print(">책번:");
							int bookId = sc.nextInt();
							
							bookDao.bookUpdate(title, pub, pubDate, author, rentStatus, bookId);
							
							System.out.println("           [책이 수정되었습니다]       ");
							System.out.println("***************************************");
						}else if (num == 3) {
							System.out.println("          [책관리:삭제]        ");
							
							System.out.print(">책 아이디:");
							int bookId = sc.nextInt();
							
							bookDao.bookDelete(bookId);
							
							System.out.println("           [책이 삭제되었습니다]       ");
							System.out.println("***************************************");
						}else if (num == 4) {
							
							List<BookVo> bookList = bookDao.bookList();
							for(BookVo bookVo : bookList) {
								System.out.println(bookVo.getBookId()  + ". "
												 + bookVo.getTitle()   + ", "
												 + bookVo.getPubs()    + ", "
												 + bookVo.getPubDate() + ", "
												 + bookVo.getAuthor()
												   );
								/*
								System.out.println("검색 (책번호를 입력하세요) : ");
								int search = sc.nextInt();
								for(int i = 0; i < bookList.size(); i++) {
									if(bookList.get(i).getBookId() == search) {
										System.out.println(bookList.get(i).getBookId()  + ". "
												 + bookList.get(i).getTitle()   + ", "
												 + bookList.get(i).getPubs()    + ", "
												 + bookList.get(i).getPubDate() + ", "
												 + bookList.get(i).getAuthor()
												 );
									}
									continue;
								}*/	
						}
					}
				}//3번 책관리
			
			}if(no == 4) {
				System.out.println("***************************************");
				System.out.println("***************감사합니다**************");
				break;
			}//4번 종료
			
			
			else {
				System.out.println("다시 입력해주세요");
			}//그외 번호 재입력 출력
		
		}
	}

}
