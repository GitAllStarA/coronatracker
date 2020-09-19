package coronavirus.updates.corona.virus.update;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronaVirusUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaVirusUpdateApplication.class, args);
	}

}
