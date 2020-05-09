package com.coinrui.api.exception;

import com.coinrui.api.ApiError;

/**
 * An exception which can occur while invoking methods of the Hx API.
 */
public class CoinRuiApiException extends RuntimeException {

	private static final long serialVersionUID = 3788669840036201041L;
	/**
	 * Error response object returned by Hx API.
	 */
	private ApiError error;

	/**
	 * Instantiates a new Hx api exception.
	 *
	 * @param error an error response object
	 */
	public CoinRuiApiException(ApiError error) {
		this.error = error;
	}

	/**
	 * Instantiates a new Hx api exception.
	 */
	public CoinRuiApiException() {
		super();
	}

	/**
	 * Instantiates a new Hx api exception.
	 *
	 * @param message the message
	 */
	public CoinRuiApiException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new Hx api exception.
	 *
	 * @param cause the cause
	 */
	public CoinRuiApiException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new Hx api exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public CoinRuiApiException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @return the response error object from Hx API, or null if no response object
	 *         was returned (e.g. server returned 500).
	 */
	public ApiError getError() {
		return error;
	}

	@Override
	public String getMessage() {
		if (error != null) {
			return error.getMsg();
		}
		return super.getMessage();
	}
}
