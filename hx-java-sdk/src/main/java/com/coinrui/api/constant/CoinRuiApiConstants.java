package com.coinrui.api.constant;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout Hx's API.
 */
public class CoinRuiApiConstants {

	private static final String WEB_SERVER_ADDR = "localhost:8888";
	
	private static final String API_SERVER_ADDR = "localhost:8887";
	/**
	 * REST API base URL.
	 */
	public static final String API_BASE_URL = "http://" + WEB_SERVER_ADDR;

	/**
	 * Streaming API base URL.
	 */
	public static final String WS_API_BASE_URL = "wss://" + API_SERVER_ADDR + "/ws";

	/**
	 * Asset info base URL.
	 */
	public static final String ASSET_INFO_API_BASE_URL = "https://" + WEB_SERVER_ADDR + "/";

	/**
	 * HTTP Header to be used for API-KEY authentication.
	 */
	public static final String API_KEY_HEADER = "X-HX-APIKEY";

	/**
	 * Decorator to indicate that an endpoint requires an API key.
	 */
	public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "X-HX-APIKEY";
	public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";

	/**
	 * Decorator to indicate that an endpoint requires a signature.
	 */
	public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
	public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";

	/**
	 * Default receiving window.
	 */
	public static final long DEFAULT_RECEIVING_WINDOW = 60_000L;

	/**
	 * Default ToStringStyle used by toString methods. Override this to change the
	 * output format of the overridden toString methods. - Example
	 * ToStringStyle.JSON_STYLE
	 */
	public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
