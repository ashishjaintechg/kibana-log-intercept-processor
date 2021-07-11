package test.ashishjaintechg.jpa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.output.TeeOutputStream;
import org.apache.commons.lang3.StringUtils;

/**
 * Wrapper to wrap HttpServletResponse.
 */
public class HttpResponseWrapper extends HttpServletResponseWrapper {

	/** The bos. */
	private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

	/**
	 * Instantiates a new http response wrapper.
	 *
	 * @param response the response
	 */
	public HttpResponseWrapper(final HttpServletResponse response) {
		super(response);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.ServletResponseWrapper#getResponse()
	 */
	@Override
	public ServletResponse getResponse() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.ServletResponseWrapper#getOutputStream()
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new ServletOutputStream() {
			private final TeeOutputStream tee = new TeeOutputStream(HttpResponseWrapper.super.getOutputStream(), bos);

			@Override
			public void write(int b) throws IOException {
				tee.write(b);
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setWriteListener(WriteListener arg0) {
				// No implementation needed for sync HTTP
			}
		};
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.ServletResponseWrapper#getWriter()
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(bos, StandardCharsets.UTF_8));
		return new ApplicationPrintWriter(super.getWriter(), writer);
	}

	/**
	 * To byte array.
	 *
	 * @return the byte[]
	 */
	public byte[] toByteArray() {
		return bos.toByteArray();
	}

	/**
	 * Gets the response payload.
	 *
	 * @return the response payload
	*/
	public String getResponsePayload() {
		StringBuilder payload = new StringBuilder();
		if (StringUtils.isEmpty(this.getHeader("BinaryFile"))) {
			byte[] bytes = this.toByteArray();
			if (bytes.length != 0) {
				payload.append(new String(bytes, 0, bytes.length, StandardCharsets.UTF_8));
			}
		}
		return payload.toString();
	}

}