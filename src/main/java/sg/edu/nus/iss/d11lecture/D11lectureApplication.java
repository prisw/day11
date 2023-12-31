package sg.edu.nus.iss.d11lecture;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class D11lectureApplication {

	public static void main(String[] args) {
		//this statement not needed as we import the SPA in
		//SpringApplication.run(D11lectureApplication.class, args);

		SpringApplication app = new SpringApplication(D11lectureApplication.class);
		
		String port = "8080";
		ApplicationArguments argOptions = new DefaultApplicationArguments(args);

		if(argOptions.containsOption("port")) {
			port = argOptions.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port",port));
		app.run(args);

		System.out.println("My first spring-boot application started...");
	}

	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	}
}	

