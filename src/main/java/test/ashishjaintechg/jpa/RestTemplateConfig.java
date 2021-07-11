package test.ashishjaintechg.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Autowired
	private LoggingClientHttpRequestInterceptor loggingClientHttpRequestInterceptor;
	
	@Bean
	public RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplateBuilder().
//				additionalInterceptors(Arrays.asList(clientHttpRequestInterceptorTest)).
//				build();
//		SimpleClientHttpRequestFactory smp = new SimpleClientHttpRequestFactory();
//		BufferingClientHttpRequestFactory  bchf = new BufferingClientHttpRequestFactory(smp);
//		restTemplate.setRequestFactory(bchf);
		
		ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.getInterceptors().add(loggingClientHttpRequestInterceptor);
		return restTemplate;
	}
	

}
