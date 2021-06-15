package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("bag") // 괄호 생략 시 자동으로 클래스 소문자 이름 사용
@Component
public class Bag {
	private Book book;
	
//	public Bag() {
//		
//	}
	
	@Autowired // 해당 타입의 빈 주입 (여기선 @Component("book"))
	public Bag(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Bag [book=" + book + "]";
	}
	
//	@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
}
