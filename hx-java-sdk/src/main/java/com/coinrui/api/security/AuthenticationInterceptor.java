package com.coinrui.api.security;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

import com.coinrui.api.constant.CoinRuiApiConstants;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

/**
 * A request interceptor that injects the API Key Header into requests, and
 * signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {

	private final String apiKey;

	private final String secret;

	public AuthenticationInterceptor(String apiKey, String secret) {
		this.apiKey = apiKey;
		this.secret = secret;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request original = chain.request();
		Request.Builder newRequestBuilder = original.newBuilder();

		newRequestBuilder.addHeader(CoinRuiApiConstants.API_KEY_HEADER, apiKey);

		String payload = original.url().query();
		if (!StringUtils.isEmpty(payload)) {

			String signParam = payload + "," + secret;
			String signature = Base64.getEncoder().encodeToString(signParam.getBytes());
			HttpUrl signedUrl = original.url().newBuilder().addQueryParameter("signature", signature).build();
			newRequestBuilder.url(signedUrl);
		}

		// Build new request after adding the necessary authentication information
		Request newRequest = newRequestBuilder.build();
		return chain.proceed(newRequest);
	}

	/**
	 * Extracts the request body into a String.
	 *
	 * @return request body as a string
	 */
	@SuppressWarnings("unused")
	private static String bodyToString(RequestBody request) {
		try (final Buffer buffer = new Buffer()) {
			final RequestBody copy = request;
			if (copy != null) {
				copy.writeTo(buffer);
			} else {
				return "";
			}
			return buffer.readUtf8();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final AuthenticationInterceptor that = (AuthenticationInterceptor) o;
		return Objects.equals(apiKey, that.apiKey) && Objects.equals(secret, that.secret);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apiKey, secret);
	}
}