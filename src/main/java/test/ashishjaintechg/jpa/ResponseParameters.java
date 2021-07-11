package test.ashishjaintechg.jpa;

import java.util.Map;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class ResponseParameters.
 */
@JsonPropertyOrder({ "responseTime", "responseCode", "contentType", "encoding", "headers", "payload" })
public class ResponseParameters extends ReqResParms {

	/** The response code. */
	private String responseCode;

	/** The response time. */
	private long responseTime;

	/**
	 * Gets the response code.
	 *
	 * @return the response code
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * Sets the response code.
	 *
	 * @param responseCode the response code
	 * @return the req res parms
	 */
	public ResponseParameters setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		return this;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType the content type
	 * @return the req res parms
	 */
	@Override
	public ResponseParameters setContentType(String contentType) {
		this.contentType = contentType;
		return this;
	}

	/**
	 * Sets the encoding.
	 *
	 * @param encoding the encoding
	 * @return the req res parms
	 */
	@Override
	public ResponseParameters setEncoding(String encoding) {
		this.encoding = encoding;
		return this;
	}

	/**
	 * Sets the headers.
	 *
	 * @param headers the headers
	 * @return the req res parms
	 */
	@Override
	public ResponseParameters setHeaders(Map<String, String> headers) {
		this.headers = headers;
		return this;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload the payload
	 * @return the req res parms
	 */
	@Override
	public ResponseParameters setPayload(String payload) {
		this.payload = payload;
		return this;
	}

	/**
	 * Gets the response time.
	 *
	 * @return the response time
	 */
	public long getResponseTime() {
		return responseTime;
	}

	/**
	 * Sets the response time.
	 *
	 * @param responseTime the response time
	 * @return the response parameters
	 */
	public ResponseParameters setResponseTime(long responseTime) {
		this.responseTime = responseTime;
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder response = new StringBuilder("Response:-")
				.append("Response Time: ").append(this.responseTime)
				.append("mills, ").append("Response-Code:")
				.append(this.responseCode).append(", ").append("Payload: ").append(this.payload);
		return response.toString();
	}

}