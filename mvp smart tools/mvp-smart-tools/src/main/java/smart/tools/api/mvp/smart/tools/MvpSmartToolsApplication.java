package smart.tools.api.mvp.smart.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MvpSmartToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvpSmartToolsApplication.class, args);
	}

}
