package practice_05.book;

public class Book {
	
	// 도서관리 번호
	private int num;
	// 도서 제목
    private String title;
	// 도서 저자
	private String author;
	
	public Book() {}

	public Book(int num, String title, String author) {
		setNum(num);
		setTitle(title);
		setAuthor(author);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num < 1) {
			return;
		}
		this.num = num;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null || title.equals("")) {
			System.out.println("정상적인 제목이 아닙니다.");
			return;
		}
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author == null || author.equals("")) {
			System.out.println("정상적인 작성자가 아닙니다.");
			return;
		}
		this.author = author;
	}

	public String toString() {
		return "Book{ [num : "+this.num+"] [title : " +this.title +"] [author : " + this.author + "]}";
	}

}
