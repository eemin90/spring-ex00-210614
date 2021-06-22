package core.test3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // @Autowired 설정 시 우선적으로 주입되게 함
public class FireSword implements Sword {

}
