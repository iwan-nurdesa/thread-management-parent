package id.co.bcafinance.msthreadasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MsThreadAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsThreadAsyncApplication.class, args);
	}

}
