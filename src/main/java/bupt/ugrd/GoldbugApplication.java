package bupt.ugrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GoldbugApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldbugApplication.class, args);
	}


	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}
}
