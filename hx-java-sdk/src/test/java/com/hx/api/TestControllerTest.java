package com.hx.api;

import org.junit.Test;

import com.coinrui.api.CoinRuiApiClientFactory;
import com.hx.common.model.Result;
/**
 * Copyright:   coinrui.com
 *
 * @author: 颜小杰
 * @version: V1.0
 * @Date: 2020年4月19日
 */
public class TestControllerTest {

	private String apiKey = "6c6a103aabc646108775573f6ff0db2b28203d491ade4ade96ffa298caa93194";
	private String secret = "df257f3e27e14670ad50f0fd3d729434500ad1dcec4e4359bb0086d9cd686e7b";

	/**
	 * 测试类
	 */
	@Test
	public void test1() {

		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().test1("BTC",30);
		System.out.println(result);

	}

	@Test
	public void getCoinPairFee() {

		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getCoinPairFee();
		System.out.println(result);

	}
	@Test
	public void getAllKeypairTicker() {
		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getAllKeypairTicker();
		System.out.println(result);
		
	}
	@Test
	public void getCoinAccountStatu() {

		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getCoinAccountStatu();
		System.out.println(result);

	}
	@Test
	public void getExtractHistroy() {

		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getExtractHistroy("BIK", "2", "0", "5", "1582120082000", "1587304126777");
		System.out.println(result);

	}
	@Test
	public void getChargeHistroy() {

		CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
		Result result = client.newRestClient().getChargeHistroy("BIK", "1582120082000", "1587304126777");
		System.out.println(result);

	}





}
