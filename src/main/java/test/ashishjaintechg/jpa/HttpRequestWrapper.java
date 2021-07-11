package test.ashishjaintechg.jpa;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Class HttpRequestWrapper.
 */
public class HttpRequestWrapper extends HttpServletRequestWrapper {

	/** The request body. */
	private String requestBody;

	/**
	 * Gets the request body.
	 *
	 * @return the request body
	 */
	public String getRequestBody() {
		return requestBody;
	}

	/**
	 * Instantiates a new http request wrapper.
	 *
	 * @param request the request
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public HttpRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		extractRequestBody(request);
	}

	/**
	 * Extract request body.
	 *
	 * @param request the request
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void extractRequestBody(HttpServletRequest request) throws IOException {
		StringBuilder body = new StringBuilder("");
		try (BufferedReader bufferedReader = request.getReader()) {
			String line;
			while (null != (line = bufferedReader.readLine())) {
				body.append(line);
			}
		}
		requestBody = body.toString();
	}

	/**
	 * THis method will provide input stream object of request body contained in
	 * current objects scope.
	 *
	 * @return the input stream
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody.getBytes());
		return new ServletInputStream() {

			@Override
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}

			@Override
			public boolean isReady() {
				return true;
			}

			@Override
			public void setReadListener(ReadListener readListener) {
				// No read listeners required
			}

			@Override
			public boolean isFinished() {
				return true;
			}
		};
	}

	/**
	 * Gets the reader.
	 *
	 * @return the reader
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}

}