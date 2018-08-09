package MenuTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.djl.Application;
import com.djl.service.MenuService;

@RunWith(SpringRunner.class) // spring环境运行
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuTest {

	@Autowired
	private MenuService menuService;

	@Test
	public void testHello() {

		String jb = menuService.initMenu();
		System.out.println(jb);
	}

}
