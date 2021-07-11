package test.ashishjaintechg.jpa;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class RequestResponseHelperServiceImpl provides implementation to all
 * methods defined in RequestResponseHelperService.
 */
@Service
@Slf4j
public class RequestResponseHelperServiceImpl implements RequestResponseHelperService {


	
//	@Autowired
//	private JsonHelper jsonHelper;



	@Override
	public KibanaLogParams populateKibanaLogParams(RequestParmeters requestParams, ResponseParameters responseLogProps)
			throws IOException {
//		ResponseMetaDTO responseMetaDTO = getErrorResponseMetaDTO(responseLogProps);
		KibanaLogParams params = KibanaThreadLocal.getValue(new KibanaLogParams());
		if (StringUtils.isEmpty(params.getApplicationServiceId())) {
			params.setApplicationServiceId("kibana-service-logs");
		}
		return params.setUri(requestParams.getAddress())
				.setId2(MDC.get("CHANNEL"))
				.setDate1(requestParams.getRequestTime().toString()).setDate2(LocalDateTime.now().toString())
				.setRequest(requestParams.toString()).setResponse(responseLogProps.toString())
				.setHttpStatus("200")
				.setErrorMessage("SUCCESS")
				.setRequestProcessingTime(getProcessingTime(requestParams.getRequestTime()));
	}
	@Override
	public KibanaLogParams populateKibanaLogParamsForUpcomingRequest(RequestParmeters requestParams, ResponseParameters responseLogProps)
			throws IOException {
		KibanaLogParams params = KibanaThreadLocal.getValue(new KibanaLogParams()).setApplicationServiceId("kibana-service-logs").setUri(requestParams.getAddress())
				.setId6(requestParams.getHeaders().get("CHANNEL"))
				.setDate1(requestParams.getRequestTime().toString()).setDate2(LocalDateTime.now().toString())
				.setRequest(requestParams.toString()).setResponse(responseLogProps.toString())
				.setHttpStatus("200")
				.setErrorMessage("SUCCESS")
				.setRequestProcessingTime(getProcessingTime(requestParams.getRequestTime()));
//		if (StringUtils.isNoneBlank(requestParams.getPayload())) {
//			AgentRequest request = jsonHelper.jsonToEntity(requestParams.getPayload(), AgentRequest.class);
//			if (request != null) {
//				params.setId1(request.getPartnerId());
//				params.setId2(request.getAgentId());
//				params.setId3(request.getServiceId());
//			}
//		}
//
		return params;
	}
	@Override
	public RequestParmeters populateRequestParameters(HttpRequest request, byte[] body, LocalDateTime requestTime) {
		RequestParmeters params = new RequestParmeters().setHttpMethod(request.getMethod().toString()).setRequestTime(requestTime)
				.setAddress(request.getURI().toString()).setHeaders(WebUtil.getHeaders(request.getHeaders()))
				.setPayload(requestPayload(request, body));
		log.info("{}", params);
		return params;
	}

	@Override
	public ResponseParameters populateResponseParameters(ClientHttpResponse response, long responseTimeMills)
			throws IOException {
		ResponseParameters params = new ResponseParameters().setResponseTime(responseTimeMills)
				.setResponseCode(String.valueOf(response.getRawStatusCode()))
				.setHeaders(WebUtil.getHeaders(response.getHeaders())).setPayload(getResponsePayload(response));
		log.info("{}", params);
		return params;
	}

	/**
	 * Gets the response payload.
	 *
	 * @param response the response
	 * @return the response payload
	 */
	private String getResponsePayload(ClientHttpResponse response) {
		StringBuilder payload = new StringBuilder();
		long contentLength = response.getHeaders().getContentLength();
		if (contentLength != 0 && hasKnownMediaTypeData(response.getHeaders())) {
			try {
				payload.append(StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));
			} catch (IOException e) {
				log.error("Not able to extract response payload");
			}
		}
		return payload.toString().replaceAll("\r", "").replaceAll("\n", "").replaceAll("\\s+", " ");
	}

	/**
	 * Checks for text body.
	 *
	 * @param headers the headers
	 * @return true, if successful
	 */
	protected boolean hasKnownMediaTypeData(HttpHeaders headers) {
		MediaType contentType = headers.getContentType();
		String subtype = contentType.getSubtype();
		return "text".equals(subtype) || "xml".equals(subtype) || "json".equals(subtype);
	}

	/**
	 * Gets the response meta DTO.
	 *
	 * @param responseLogProps the response log props
//	 * @return the response meta DTO
//	 */
//	private ResponseMetaDTO getErrorResponseMetaDTO(ResponseParameters responseLogProps) {
//		ResponseMetaDTO responseMetaDTO = null;
//		String responseString = responseLogProps.getPayload();
//		if (StringUtils.isNotEmpty(responseString)) {
//			ErrorResponseDTO errorResponseMetaDTO = jsonHelper.jsonToEntity(responseString, ErrorResponseDTO.class);
//			if (null != errorResponseMetaDTO) {
//				responseMetaDTO = errorResponseMetaDTO.getMeta();
//			}
//		}
//
//		return responseMetaDTO;
//	}

	/**
	 * Gets the error code.
	 *
	 * @param responseMetaDTO the response meta DTO
	 * @return the error code
	 */
//	private String getErrorCode(ResponseMetaDTO responseMetaDTO) {
//
//		String errorCode = null;
//		if (null != responseMetaDTO) {
//			errorCode = responseMetaDTO.getCode();
//		}
//		return errorCode;
//
//	}

	/**
	 * Gets the error message.
	 *
	 * @param responseMetaDTO the response meta DTO
//	 * @return the error message
//	 */
//	private String getErrorMessage(ResponseMetaDTO responseMetaDTO) {
//
//		String errorMessage = null;
//		if (null != responseMetaDTO) {
//			errorMessage = responseMetaDTO.getDescription();
//		}
//		return errorMessage;
//	}
	/**
	 * Gets the processing time.
	 *
	 * @param requestTime the request time
	 * @return the processing time
	 */
	private long getProcessingTime(LocalDateTime requestTime) {
		return Duration.between(requestTime, LocalDateTime.now()).toMillis();
	}

	/**
	 * Request payload.
	 *
	 * @param request the request
	 * @param body    the body
	 * @return the string
	 */
	private String requestPayload(HttpRequest request, byte[] body) {
		String payload = StringUtils.EMPTY;
		if (body.length > 0 && hasKnownMediaTypeData(request.getHeaders())) {
			payload = new String(body, StandardCharsets.UTF_8);
		}
		return payload.replaceAll("\r", "").replaceAll("\n", "").replaceAll("\\s+", " ");
	}

}