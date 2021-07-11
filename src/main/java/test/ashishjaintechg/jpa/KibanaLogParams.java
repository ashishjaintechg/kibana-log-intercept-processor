package test.ashishjaintechg.jpa;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Instantiates a new kibana log params.
 */
@Data
public class KibanaLogParams {

	/** The Constant PIPE. */
	private static final String SEPARATOR = "~#~";

	/** The application service id. */
	private String applicationServiceId;

	/** The uri. */
	private String uri;

	/** The cust mobile no. */
	private String custMobileNo;

	/** The content Id. */
	private String contentId;

	/** The txn id. */
	private String txnId;

	/** The amount. */
	private String amount = "0.0";

	/** The id 1. */
	private String id1;

	/** The id 2. */
	private String id2;

	/** The id 3. */
	private String id3;

	/** The id 4. */
	private String id4;

	/** The id 5. */
	private String id5;

	/** The id 6. */
	private String id6;

	/** The id 7. */
	private String id7;

	/** The id 8. */
	private String id8;

	/** The id 9. */
	private String id9;

	/** The id 10. */
	private String id10;

	/** The number 1. */
	private String number1;

	/** The number 2. */
	private String number2;

	/** The number 3. */
	private String number3;

	/** The date 1. */
	private String date1;

	/** The date 2. */
	private String date2;

	/** The request. */
	private String request;

	/** The response. */
	private String response;

	/** The http status. */
	private String httpStatus;

	/** The error code. */
	private String errorCode;

	/** The error message. */
	private String errorMessage;

	/** The time taken. */
	private long requestProcessingTime;

	public KibanaLogParams() {
		this.amount = "0.0";
	}

	/**
	 * Sets the application service id.
	 *
	 * @param applicationServiceId the application service id
	 * @return the kibana log params
	 */
	public KibanaLogParams setApplicationServiceId(String applicationServiceId) {
		this.applicationServiceId = applicationServiceId;
		return this;
	}

	/**
	 * Sets the uri.
	 *
	 * @param uri the uri
	 * @return the kibana log params
	 */
	public KibanaLogParams setUri(String uri) {
		this.uri = uri;
		return this;
	}

	/**
	 * Sets the cust mobile no.
	 *
	 * @param custMobileNo the cust mobile no
	 * @return the kibana log params
	 */
	public KibanaLogParams setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
		return this;
	}

	/**
	 * Sets the content id.
	 *
	 * @param contentId the content id
	 * @return the kibana log params
	 */
	public KibanaLogParams setContentId(String contentId) {
		this.contentId = contentId;
		return this;
	}

	/**
	 * Sets the txn id.
	 *
	 * @param txnId the txn id
	 * @return the kibana log params
	 */
	public KibanaLogParams setTxnId(String txnId) {
		this.txnId = txnId;
		return this;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the amount
	 * @return the kibana log params
	 */
	public KibanaLogParams setAmount(String amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Sets the id 1.
	 *
	 * @param id1 the id 1
	 * @return the kibana log params
	 */
	public KibanaLogParams setId1(String id1) {
		this.id1 = id1;
		return this;
	}

	/**
	 * Sets the id 2.
	 *
	 * @param id2 the id 2
	 * @return the kibana log params
	 */
	public KibanaLogParams setId2(String id2) {
		this.id2 = id2;
		return this;
	}

	/**
	 * Sets the id 3.
	 *
	 * @param id3 the id 3
	 * @return the kibana log params
	 */
	public KibanaLogParams setId3(String id3) {
		this.id3 = id3;
		return this;
	}

	/**
	 * Sets the id 4.
	 *
	 * @param id4 the id 4
	 * @return the kibana log params
	 */
	public KibanaLogParams setId4(String id4) {
		this.id4 = id4;
		return this;
	}

	/**
	 * Sets the id 5.
	 *
	 * @param id5 the id 5
	 * @return the kibana log params
	 */
	public KibanaLogParams setId5(String id5) {
		this.id5 = id5;
		return this;
	}

	/**
	 * Sets the id 6.
	 *
	 * @param id6 the id 6
	 * @return the kibana log params
	 */
	public KibanaLogParams setId6(String id6) {
		this.id6 = id6;
		return this;
	}

	/**
	 * Sets the id 7.
	 *
	 * @param id7 the id 7
	 * @return the kibana log params
	 */
	public KibanaLogParams setId7(String id7) {
		this.id7 = id7;
		return this;
	}

	/**
	 * Sets the id 8.
	 *
	 * @param id8 the id 8
	 * @return the kibana log params
	 */
	public KibanaLogParams setId8(String id8) {
		this.id8 = id8;
		return this;
	}

	/**
	 * Sets the id 9.
	 *
	 * @param id9 the id 9
	 * @return the kibana log params
	 */
	public KibanaLogParams setId9(String id9) {
		this.id9 = id9;
		return this;
	}

	/**
	 * Sets the id 10.
	 *
	 * @param id10 the id 10
	 * @return the kibana log params
	 */
	public KibanaLogParams setId10(String id10) {
		this.id10 = id10;
		return this;
	}

	/**
	 * Sets the number 1.
	 *
	 * @param number1 the number 1
	 * @return the kibana log params
	 */
	public KibanaLogParams setNumber1(String number1) {
		this.number1 = number1;
		return this;
	}

	/**
	 * Sets the number 2.
	 *
	 * @param number2 the number 2
	 * @return the kibana log params
	 */
	public KibanaLogParams setNumber2(String number2) {
		this.number2 = number2;
		return this;
	}

	/**
	 * Sets the number 3.
	 *
	 * @param number3 the number 3
	 * @return the kibana log params
	 */
	public KibanaLogParams setNumber3(String number3) {
		this.number3 = number3;
		return this;
	}

	/**
	 * Sets the date 1.
	 *
	 * @param date1 the date 1
	 * @return the kibana log params
	 */
	public KibanaLogParams setDate1(String date1) {
		this.date1 = date1;
		return this;
	}

	/**
	 * Sets the date 2.
	 *
	 * @param date2 the date 2
	 * @return the kibana log params
	 */
	public KibanaLogParams setDate2(String date2) {
		this.date2 = date2;
		return this;
	}

	/**
	 * Sets the request.
	 *
	 * @param request the request
	 * @return the kibana log params
	 */
	public KibanaLogParams setRequest(String request) {
		this.request = request;
		return this;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the response
	 * @return the kibana log params
	 */
	public KibanaLogParams setResponse(String response) {
		this.response = response;
		return this;
	}

	/**
	 * Sets the http status.
	 *
	 * @param httpStatus the http status
	 * @return the kibana log params
	 */
	public KibanaLogParams setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
		return this;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the error code
	 * @return the kibana log params
	 */
	public KibanaLogParams setErrorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the error message
	 * @return the kibana log params
	 */
	public KibanaLogParams setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	/**
	 * Sets the request processing time.
	 *
	 * @param requestProcessingTime the request processing time
	 * @return the kibana log params
	 */
	public KibanaLogParams setRequestProcessingTime(long requestProcessingTime) {
		this.requestProcessingTime = requestProcessingTime;
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder logLine = new StringBuilder(this.applicationServiceId).append(SEPARATOR)
				.append(StringUtils.defaultString(this.uri)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.custMobileNo)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.contentId)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.txnId)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.amount)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id1)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id2)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id3)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id4)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id5)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id6)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id7)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id8)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id9)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.id10)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.number1)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.number2)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.number3)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.date1)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.date2)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.request)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.response)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.httpStatus)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.errorCode)).append(SEPARATOR)
				.append(StringUtils.defaultString(this.errorMessage)).append(SEPARATOR)
				.append(this.requestProcessingTime);
		return logLine.toString();

	}

}