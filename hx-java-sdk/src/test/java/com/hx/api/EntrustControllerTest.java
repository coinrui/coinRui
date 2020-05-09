package com.hx.api;

import org.junit.Test;

import com.coinrui.api.CoinRuiApiClientFactory;
import com.hx.common.model.Result;

public class EntrustControllerTest {
	
	private String apiKey = "6c6a103aabc646108775573f6ff0db2b28203d491ade4ade96ffa298caa93194";
	private String secret = "df257f3e27e14670ad50f0fd3d729434500ad1dcec4e4359bb0086d9cd686e7b";
	
	@Test
	public void getOpenOrders() {
		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getOpenOrders("BTC_USDT");
		System.out.println(result);
	}
	
	@Test
	public void getAllOrders() {
		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getAllOrders("BTC_USDT", 0L, 0L, 100L);
		System.out.println(result);
	}
	
	@Test
	public void getOrder() {
		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getOrder("BTC_USDT","1545646");
		System.out.println(result);
	}
	
	@Test
	public void getHistoryOrders() {
		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getHistoryOrders("BTC_USDT", 0L, 0L, 100L);
		System.out.println(result);
	}
	
	@Test
	public void order() {
		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().order("ETH_USDT", 1, "200", "10", "1", "0", "AA123456", "ACK");
		System.out.println(result);
	}
	
	@Test
	public void closeOrder() {
		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().delOrder("BTC_USDT","5465465465");
		System.out.println(result);
	}
}
