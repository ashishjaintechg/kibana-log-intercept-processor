package test.ashishjaintechg.jpa;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * The Class WebUtil provide methods to deal with HttpServletRequest.
 */
@Component
public class WebUtil {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebUtil.class);

	/**
	 * Instantiates a new web util.
	 */
	private WebUtil() {

	}

	/**
	 * This method wil extract all headers from request and returns them as
	 * key-value pair via HashMap.
	 *
	 * @param request the request
	 * @return the headers info
	 */
	public static Map<String, String> getHeaders(HttpServletRequest request) {
		LOGGER.debug("Extracting headers from http servlet request.");
		Map<String, String> headers = new HashMap<>();

		Enumeration<String> headerNames = request.getHeaderNames();
		if (null != headerNames) {
			while (headerNames.hasMoreElements()) {
				String key = headerNames.nextElement();
				String value = request.getHeader(key);
				headers.put(key, value);
			}
		}
		headers.remove("accept-charset");
		return headers;
	}

	/**
	 * Flat headers.
	 *
	 * @param httpHeaders the http headers
	 * @return the map
	 */
	public static Map<String, String> getHeaders(HttpHeaders httpHeaders) {
		Map<String, String> headers = new HashMap<>();
		for (Entry<String, List<String>> entry : httpHeaders.entrySet()) {
			headers.put(entry.getKey(), entry.getValue().stream().collect(Collectors.joining(",")));
		}
		headers.remove("Accept-Charset");
		return headers;
	}

	/**
	 * This method wil extract all headers from request and returns them as
	 * key-value pair via HashMap.
	 *
	 * @param response the request
	 * @return the headers info
	 */
	public static Map<String, String> getHeaders(HttpServletResponse response) {
		LOGGER.debug("Extracting headers from request.");
		Map<String, String> headers = new HashMap<>();

		Collection<String> headerNames = response.getHeaderNames();
		if (null != headerNames) {
			for (String key : headerNames) {
				String value = response.getHeader(key);
				headers.put(key, value);
			}
		}
		return headers;
	}

}