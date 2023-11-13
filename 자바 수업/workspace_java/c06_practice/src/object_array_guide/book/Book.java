package object_array_guide.book;

public class Book {
	
	// 도서관리 번호
	int num;
	// 도서 제목
    String title;
	// 도서 저자
	String author;
	
	
	public Book() {}

	public Book(int num, String title, String author) {
		this.num = num;
		this.title = title;
		this.author = author;
	}

	public String toString() {
		return "Book{ [num : "+this.num+"] [title : " +this.title +"] [author : " + this.author + "]}";
	}

}
