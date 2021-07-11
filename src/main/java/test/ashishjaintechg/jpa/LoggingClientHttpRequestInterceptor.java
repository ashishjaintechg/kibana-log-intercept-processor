package test.ashishjaintechg.jpa;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Allows logging outgoing requests and the corresponding responses. Requires
 * the use of a
 * {@link org.springframework.http.client.BufferingClientHttpRequestFactory} to
 * log the body of received responses.
 */
@Slf4j
@Component
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

	/** The request response helper service. */
	@Autowired
	private RequestResponseHelperService requestResponseHelperService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.http.client.ClientHttpRequestInterceptor#intercept(org.
	 * springframework.http.HttpRequest, byte[],
	 * org.springframework.http.client.ClientHttpRequestExecution)
	 */
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		LocalDateTime requestTime = LocalDateTime.now();
		RequestParmeters requestParams = requestResponseHelperService.populateRequestParameters(request, body,
				requestTime);
		ClientHttpResponse response = null;
		try {
			response = execution.execute(request, body);
		} finally {
			if (null != response) {
				ResponseParameters responseParams = requestResponseHelperService.populateResponseParameters(response,
						Duration.between(requestTime, LocalDateTime.now()).toMillis());
				KibanaLogParams kibanaLogParams = requestResponseHelperService.populateKibanaLogParams(requestParams,
						responseParams);
				log.info("{}", kibanaLogParams);
			}
		}

		return response;
	}

}