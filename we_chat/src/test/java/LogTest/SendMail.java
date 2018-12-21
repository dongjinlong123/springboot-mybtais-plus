package LogTest;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import com.djl.Application;
@RunWith(SpringRunner.class) // spring环境运行
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SendMail {
	@Autowired
	private JavaMailSender javaMailSender;

	@Test
	public void testEmail() {

		JavaMailSender sneder =javaMailSender ;

		MimeMessage message = sneder.createMimeMessage();// 新建邮件
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);// 编辑发送内容
		try {
			messageHelper.setFrom("904118787@qq.com");
			messageHelper.setTo("316799047@qq.com");
			messageHelper.setSubject("主题");
			messageHelper.setText("内容");
		} catch (MessagingException e) {

			e.printStackTrace();
		}
		System.out.println("发送成功");
		sneder.send(message);// 发送
	}
}
