package test.ashishjaintechg.jpa;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
	public class RequestResponseLogFilter extends OncePerRequestFilter {


	/** The request response helper service. */
	@Autowired
	private RequestResponseHelperService requestResponseHelperService;



	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

				try {

					LocalDateTime requestTime = LocalDateTime.now();
					final HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(request);
					final HttpResponseWrapper httpResponseWrapper = new HttpResponseWrapper(response);

					KibanaLogParams params = new KibanaLogParams();

					KibanaThreadLocal.setValue(params);
					try {
						filterChain.doFilter(httpRequestWrapper, httpResponseWrapper);
					} finally {
						RequestParmeters requestParams = requestResponseHelperService
								.populateRequestParameters(httpRequestWrapper, requestTime);
						ResponseParameters responseParams = requestResponseHelperService
								.populateResponseParameters(httpResponseWrapper);
						KibanaLogParams kibanaLogParams = requestResponseHelperService
								.populateKibanaLogParamsForUpcomingRequest(requestParams, responseParams);
						log.info("{}", kibanaLogParams);
					}
				} finally {
					MDC.clear();
					KibanaThreadLocal.unset();
				}
		}
	}
