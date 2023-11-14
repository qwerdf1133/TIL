package GUIDE.book;

import java.util.Scanner;

public class BookManagement {

	// 문자열 입력
	Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	Scanner scanSelectnum = new Scanner(System.in);
	
	// 도서목록
	Book[] books = new Book[100];
	// 프로그램 실행 flag
	boolean isRun = true;
	// 메인 메뉴 선택 번호
	int selectNo = 0;
	// 도서관리 번호
	int count=1;	

	public BookManagement(){
		run();
	}
	
	public void run() {
		while(isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요 > ");
			
			switch(selectNo) {
				case 1 :
					registerBook();
					break;
				case 2 :
					selectBook();
					break;
				case 3 :
					updateBook();
					break;
				case 4 : 
					deleteBook();
					break;
				case 5 : 
					terminate();
					break;	
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			
			}
		}
	}
	
	// 프로그램 종료
	public void terminate() {
		System.out.println("프로그램 종료");
		isRun = false;
		
	}

	// 도서 등록
	public void  registerBook() {
		System.out.println("1. 도서등록");
		System.out.println("등록할 책의 제목을 입력하세요 > ");
		String book = scanLine.next();
		
		System.out.println("등록할 책의 저자를 입력하세요 > ");
		String wjwk = scanLine.next();
		
		Book newBook = new Book(count, book, wjwk);
		
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] = newBook;
				System.out.println("등록완료");
				count++;
				break;
			}
		}
		
	}
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null) {
				String book = books[i].toString();
				System.out.println(book);
			}
		}
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		System.out.println("수정할 책의 도서관리 번호를 입력하세요 > ");
		int num = scanLine.nextInt();
		
		String edit = books[num-1].toString();
		
		if(edit != null) {
			
			boolean editing = true;
			
			while(editing) {
				System.out.println(books[num-1].toString());
				System.out.println("===================================");
				System.out.println("1. 제목 수정 | 2. 저자 수정 | 3. 수정완료");
				System.out.println("===================================");
				System.out.print("번호 입력 > ");
				int selNum = scanLine.nextInt();
				
				if(selNum == 1) {
					System.out.println("제목 수정");
					System.out.println("제목 입력 >");
					String editTitle = scanLine.next();
					books[num-1].title = editTitle;
					System.out.println("제목 수정 완료");
					
				}else if(selNum == 2) {
					System.out.println("저자 수정");
					System.out.println("저자입력 > ");
					String editauthor = scanLine.next();
					books[num-1].author = editauthor;
					System.out.println("저자 수정 완료");
					
				}else if(selNum == 3) {
					System.out.println("수정 완료");
					break;
					
				}else {
					System.out.println("번호를 다시 입력해주세요.");
				}
			}
			
		}else {
			System.out.println("존재하지 않는 도서입니다.");
		}
	}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		System.out.println("삭제할 책의 도서관리 번호를 입력하세요 > ");
		int num = scanLine.nextInt();
		String del = books[num-1].toString();
		if(del != null) {
			books[num-1] = null;
			System.out.println("삭제 완료");
		}
		
	}
	
	// 책 정보 출력
	public void printBookInfo(Book b) {
		System.out.println(b.toString());
	}
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		for(int i = 0; i < books.length; i++) {
			Book book = books[num];
			if(book != null) {
				book.toString();
			}
		}
		return null;
	}
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	
	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		return scanSelectnum.nextInt();
	}
		
	public static void main(String[] args) {
		new BookManagement();
	}

}
