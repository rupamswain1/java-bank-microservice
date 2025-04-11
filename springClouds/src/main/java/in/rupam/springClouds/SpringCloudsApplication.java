package in.rupam.springClouds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudsApplication.class, args);
	}

}
