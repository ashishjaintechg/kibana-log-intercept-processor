package test.ashishjaintechg.jpa;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.NoArgsConstructor;

/**
 * RequestParmeters class represents the properties which will be logged every
 * time a request comes and response is sent.
 *
 * @return the response code
 */
@NoArgsConstructor
@JsonIgnoreProperties(value = { "address", "remoteAddress", "requestTime" })
@JsonPropertyOrder({ "httpMethod", "contentType", "encoding", "headers" })
public class RequestParmeters extends ReqResParms {

	/** The request time. */
	LocalDateTime requestTime;

	/** The http method. */
	private String httpMethod;

	/** The address. */
	private String address;

	/** The remote address. */
	private String remoteAddress;

	/**
	 * Gets the request time.
	 *
	 * @return the request time
	 */
	public LocalDateTime getRequestTime() {
		return requestTime;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets the http method.
	 *
	 * @return the http method
	 */
	public String getHttpMethod() {
		return httpMethod;
	}

	/**
	 * Gets the remote address.
	 *
	 * @return the remote address
	 */
	public String getRemoteAddress() {
		return remoteAddress;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the address
	 * @return the req res parms
	 */
	public RequestParmeters setAddress(String address) {
		this.address = address;
		return this;
	}

	/**
	 * Sets the http method.
	 *
	 * @param httpMethod the http method
	 * @return the req res parms
	 */
	public RequestParmeters setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
		return this;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType the content type
	 * @return the req res parms
	 */
	@Override
	public RequestParmeters setContentType(String contentType) {
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
	public RequestParmeters setEncoding(String encoding) {
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
	public RequestParmeters setHeaders(Map<String, String> headers) {
		this.headers = headers;
		return this;
	}

	/**
	 * Sets the remote address.
	 *
	 * @param remoteAddress the remote address
	 * @return the request parmeters
	 */
	public RequestParmeters setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
		return this;
	}

	/**
	 * Sets the request time.
	 *
	 * @param requestTime the request time
	 * @return the request parmeters
	 */
	public RequestParmeters setRequestTime(LocalDateTime requestTime) {
		this.requestTime = requestTime;
		return this;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload the payload
	 * @return the req res parms
	 */
	@Override
	public RequestParmeters setPayload(String payload) {
		this.payload = payload;
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder request = new StringBuilder("Request:-")
				.append("Http-Method:").append(this.httpMethod).append(",  ")
				.append("Address:").append(this.address).append(",  ")
				.append("Payload:").append(this.payload).append(",  ")
				.append("Headers").append(this.headers);
		return request.toString();
	}

}