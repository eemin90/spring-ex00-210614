package core.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hero {

	private Sword sword;
	
	@Autowired
	@Qualifier("waterSword") // @Qualifier(className) 설정 시 우선적으로 주입되게 함(@Primary 보다 우선)
	public void setSword(Sword sword) {
		this.sword = sword;
	}
	
	public Sword getSword() {
		return sword;
	}
}
