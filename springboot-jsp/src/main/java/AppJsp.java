

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("controller")
@EnableAutoConfiguration
public class AppJsp {
	public static void main(String[] args) {
		SpringApplication.run(AppJsp.class, args);
	}
}
