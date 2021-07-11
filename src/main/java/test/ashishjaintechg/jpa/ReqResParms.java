package test.ashishjaintechg.jpa;
import java.util.Map;

/**
 * The Class ReqResParms.
 */
public class ReqResParms {

	/** The content type. */
	String contentType;

	/** The encoding. */
	String encoding;

	/** The header. */
	Map<String, String> headers;

	/** The payload. */
	String payload;
	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
public String getContentType() {
 return contentType;
	}

	/**
	 * Gets the encoding.
	 *
	 * @return the encoding
	 */
public String getEncoding() {
 return encoding;
	}
	/**
	 * Gets the payload.
	 *
	 * @return the payload
	 */
public String getPayload() {
 return payload;
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
public Map<String, String> getHeaders() {
 return headers;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType the content type
	 * @return the req res parms
	 */
public ReqResParms setContentType(String contentType) {
 this.contentType = contentType;
 return this;
	}
	/**
	 * Sets the encoding.
	 *
	 * @param encoding the encoding
	 * @return the req res parms
	 */
public ReqResParms setEncoding(String encoding) {
 this.encoding = encoding;
 return this;
	}

	/**
	 * Sets the headers.
	 *
	 * @param headers the headers
	 * @return the req res parms
	 */
public ReqResParms setHeaders(Map<String, String> headers) {
this.headers = headers;
 return this;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload the payload
	 * @return the req res parms
	 */
public ReqResParms setPayload(String payload) {
this.payload = payload;
 return this;
	}

}