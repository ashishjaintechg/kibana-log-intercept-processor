package test.ashishjaintechg.jpa;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;

import jdk.internal.jline.internal.Log;

/**
 * The Interface RequestResponseHelperService will provide methods to process
 * HTTP request and response.
 */
public interface RequestResponseHelperService {

	/**
	 * This method will encapsulate request properties.
	 *
	 * @param request     the request
	 * @param requestTime the request time
	 * @return the request parmeters
	 */
	default RequestParmeters populateRequestParameters(HttpRequestWrapper request, LocalDateTime requestTime) {
		return new RequestParmeters().setRequestTime(requestTime).setAddress(request.getRequestURL().toString())
				.setContentType(request.getContentType()).setEncoding(request.getCharacterEncoding())
				.setHttpMethod(request.getMethod()).setHeaders(WebUtil.getHeaders(request))
				.setPayload(request.getRequestBody());
	}

	/**
	 * This method will encapsulate request properties.
	 *
	 * @param request     the request
	 * @param body        the body
	 * @param requestTime the request time
	 * @return the request parmeters
	 */
	RequestParmeters populateRequestParameters(HttpRequest request, byte[] body, LocalDateTime requestTime);

	/**
	 * This method will encapsulate response properties.
	 *
	 * @param response the response
	 * @return the request parameters
	 */
	default ResponseParameters populateResponseParameters(HttpResponseWrapper response) {
		System.out.println("--------------------"+response.getResponsePayload());
		return new ResponseParameters().setEncoding(response.getCharacterEncoding())
				.setResponseCode(String.valueOf(response.getStatus())).setContentType(response.getContentType())
				.setHeaders(WebUtil.getHeaders(response)).setPayload(response.getResponsePayload());
	}

	/**
	 * This method will encapsulate response properties.
	 *
	 * @param response          the response
	 * @param responseTimeMills the response time
	 * @return the request parameters
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	ResponseParameters populateResponseParameters(ClientHttpResponse response, long responseTimeMills)
			throws IOException;

	/**
	 * This method will generate KibanaLogParams bean containing all properties to
	 * be published on Kibana.
	 *
	 * @param requestParams  the request log props
	 * @param responseParams the response log props
	 * @return the kibana log params
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	KibanaLogParams populateKibanaLogParams(RequestParmeters requestParams, ResponseParameters responseParams)
			throws IOException;


	KibanaLogParams populateKibanaLogParamsForUpcomingRequest(RequestParmeters requestParams, ResponseParameters responseParams)
			throws IOException;

}