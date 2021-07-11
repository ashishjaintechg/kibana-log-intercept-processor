package test.ashishjaintechg.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@RestController
public class KibanaLogInterceptProcessorApplication {

	@Autowired
	private RestTemplate restTemplate;
	

    @GetMapping(value="/")
	public Coupon getGreeting() {
		Coupon coupon = restTemplate.getForObject("http://localhost:8081/couponapi/coupons/"+"SUPER10", Coupon.class);
		
    	log.info("method called "+coupon);
		return coupon;
	}
    
	public static void main(String[] args) {
		SpringApplication.run(KibanaLogInterceptProcessorApplication.class, args);
	}

}
