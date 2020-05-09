package com.coinrui.api;

import com.coinrui.api.impl.CoinRuiApiAsyncRestClientImpl;
import com.coinrui.api.impl.CoinRuiApiRestClientImpl;

/**
 * A factory for creating HxApi client objects.
 */
public class CoinRuiApiClientFactory {

	/**
	 * API Key
	 */
	private String apiKey;

	/**
	 * Secret.
	 */
	private String secret;

	/**
	 * Instantiates a new Hx api client factory.
	 *
	 * @param apiKey the API key
	 * @param secret the Secret
	 */
	private CoinRuiApiClientFactory(String apiKey, String secret) {
		this.apiKey = apiKey;
		this.secret = secret;
	}

	/**
	 * New instance.
	 *
	 * @param apiKey the API key
	 * @param secret the Secret
	 *
	 * @return the Hx api client factory
	 */
	public static CoinRuiApiClientFactory newInstance(String apiKey, String secret) {
		return new CoinRuiApiClientFactory(apiKey, secret);
	}

	/**
	 * New instance without authentication.
	 *
	 * @return the Hx api client factory
	 */
	public static CoinRuiApiClientFactory newInstance() {
		return new CoinRuiApiClientFactory(null, null);
	}

	/**
	 * Creates a new synchronous/blocking REST client.
	 */
	public CoinRuiApiRestClient newRestClient() {
		return new CoinRuiApiRestClientImpl(apiKey, secret);
	}

	/**
	 * Creates a new asynchronous/non-blocking REST client.
	 */
	public CoinRuiApiAsyncRestClient newAsyncRestClient() {
		return new CoinRuiApiAsyncRestClientImpl(apiKey, secret);
	}

}
