package com.coinrui.api.impl;

import static com.coinrui.api.impl.HxApiServiceGenerator.createService;

import com.coinrui.api.CoinRuiApiAsyncRestClient;

/**
 * Implementation of Hx's REST API using Retrofit with asynchronous/non-blocking
 * method calls.
 */
public class CoinRuiApiAsyncRestClientImpl implements CoinRuiApiAsyncRestClient {

	private final CoinRuiApiService HxApiService;

	public CoinRuiApiAsyncRestClientImpl(String apiKey, String secret) {
		HxApiService = createService(CoinRuiApiService.class, apiKey, secret);
	}

	// General endpoints


}
