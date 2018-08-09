package LogTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.djl.Application;
import com.djl.entity.WxInfoLog;
import com.djl.service.WxInfoLogService;

@RunWith(SpringRunner.class) // spring环境运行
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogTest {

	@Autowired
	private WxInfoLogService wxInfoLogService;

	@Test
	public void testHello() {
		System.out.println("开始插入数据----");
		WxInfoLog log = new WxInfoLog ();
		log.setContent("content");

		log.setFromUserName("fromuser");
		log.setImgUrl("http://image");
		log.setMediaId("123");
		log.setMsgId("111");
		log.setMsgType("msgtype");
		log.setRecognition("recognition");
		log.setResMsg("resmsg");
		log.setCreateTime("2018-06-26");
		log.setToUserName("djl");
		wxInfoLogService.saveWXLog(log);
		System.out.println("结束插入数据----");
	}

}
