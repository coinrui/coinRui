package com.coinrui.api.impl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.coinrui.api.impl.HxApiServiceGenerator.getHxApiError;

import java.io.IOException;

import com.coinrui.api.ApiCallback;
import com.coinrui.api.ApiError;
import com.coinrui.api.exception.CoinRuiApiException;

/**
 * An adapter/wrapper which transforms a Callback from Retrofit into a
 * ApiCallback which is exposed to the client.
 */
public class CoinRuiApiCallbackAdapter<T> implements Callback<T> {

	private final ApiCallback<T> callback;

	public CoinRuiApiCallbackAdapter(ApiCallback<T> callback) {
		this.callback = callback;
	}

	public void onResponse(Call<T> call, Response<T> response) {
		if (response.isSuccessful()) {
			callback.onResponse(response.body());
		} else {
			if (response.code() == 504) {
				// HTTP 504 return code is used when the API successfully sent the message but
				// not get a response within the timeout period.
				// It is important to NOT treat this as a failure; the execution status is
				// UNKNOWN and could have been a success.
				return;
			}
			try {
				ApiError apiError = getHxApiError(response);
				onFailure(call, new CoinRuiApiException(apiError));
			} catch (IOException e) {
				onFailure(call, new CoinRuiApiException(e));
			}
		}
	}

	@Override
	public void onFailure(Call<T> call, Throwable throwable) {
		if (throwable instanceof CoinRuiApiException) {
			callback.onFailure(throwable);
		} else {
			callback.onFailure(new CoinRuiApiException(throwable));
		}
	}
}
