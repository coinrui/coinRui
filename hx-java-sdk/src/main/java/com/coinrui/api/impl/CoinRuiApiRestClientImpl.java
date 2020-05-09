package com.coinrui.api.impl;

import static com.coinrui.api.impl.HxApiServiceGenerator.createService;
import static com.coinrui.api.impl.HxApiServiceGenerator.executeSync;

import com.coinrui.api.CoinRuiApiRestClient;
import com.hx.common.model.Result;

/**
 * Implementation of Hx's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class CoinRuiApiRestClientImpl implements CoinRuiApiRestClient {

	private final CoinRuiApiService HxApiService;

	public CoinRuiApiRestClientImpl(String apiKey, String secret) {
		HxApiService = createService(CoinRuiApiService.class, apiKey, secret);
	}

	@Override
	public Result test1(String coinCode, Integer limit) {
		return executeSync(HxApiService.recentlyMarkets(coinCode, limit));
	}

	@Override
	public Result recentlyMarkets(String coinCode, Integer limit) {
		return executeSync(HxApiService.recentlyMarkets(coinCode, limit));
	}

	@Override
	public Result historyMarkets(String coinCode, Integer limit, Long orderInfoId) {
		return executeSync(HxApiService.historyMarkets(coinCode, limit, orderInfoId));
	}

	@Override
	public Result averagePrice(String symbol) {
		return executeSync(HxApiService.averagePrice(symbol));
	}

	@Override
	public Result dayPrice(String symbol) {
		return executeSync(HxApiService.dayPrice(symbol));
	}

	@Override
	public Result newPrice(String symbol) {
		return executeSync(HxApiService.newPrice(symbol));
	}

	@Override
	public Result optimalOrder(String symbol) {
		return executeSync(HxApiService.optimalOrder(symbol));
	}

	@Override
	public Result serverTime() {
		return executeSync(HxApiService.serverTime());
	}

	@Override
	public Result transactionSpecification() {
		return executeSync(HxApiService.transactionSpecification());
	}

	@Override
	public Result depthInfo(String symbol, Integer limit) {
		return executeSync(HxApiService.depthInfo(symbol, limit));
	}

	@Override
	public Result isServerConnected() {
		return executeSync(HxApiService.isServerConnected());
	}

	@Override
	public Result getAllCoinInfo() {
		return executeSync(HxApiService.getAllCoinInfo());
	}

	@Override
	public Result assetsSnapshot(String startTime, String endTime, Integer limit) {
		return executeSync(HxApiService.assetsSnapshot(startTime, endTime, limit));
	}

	@Override
	public Result getChargeHistroy(String coin, String startTime, String endTime) {
		return executeSync(HxApiService.getChargeHistroy(coin, startTime, endTime));
	}

	@Override
	public Result getExtractHistroy(String coin, String status, String offset, String limit, String startTime,
			String endTime) {
		return executeSync(HxApiService.getExtractHistroy(coin, status, offset, limit, startTime, endTime));
	}

	@Override
	public Result getCoinAccountStatu() {
		return executeSync(HxApiService.getCoinAccountStatu());
	}

	@Override
	public Result getCoinPairFee() {
		return executeSync(HxApiService.getCoinPairFee());
	}

	@Override
	public Result getAllKeypairTicker() {
		return executeSync(HxApiService.getAllKeypairTicker());
	}

	@Override
	public Result getOrder(String symbol, String clientOrderId) {
		return executeSync(HxApiService.getOrder(symbol, clientOrderId));
	}

	@Override
	public Result getOpenOrders(String symbol) {
		return executeSync(HxApiService.getOpenOrders(symbol));
	}

	@Override
	public Result getAllOrders(String symbol, Long startTime, Long endTime, Long limit) {
		return executeSync(HxApiService.getAllOrders(symbol, startTime, endTime, limit));
	}

	@Override
	public Result getHistoryOrders(String symbol, Long startTime, Long endTime, Long limit) {
		return executeSync(HxApiService.getHistoryOrders(symbol, startTime, endTime, limit));
	}

	@Override
	public Result delOrder(String symbol, String clientOrderId) {
		return executeSync(HxApiService.delOrder(symbol, clientOrderId));
	}

	@Override
	public Result order(String symbol, Integer type, String entrustPrice, String entrustCount, String entrustWay,
			String stopPrice, String newClientOrderId, String newOrderRespType) {

		return executeSync(HxApiService.order(symbol, type, entrustPrice, entrustCount, entrustWay, stopPrice,
				newClientOrderId, newOrderRespType));
	}

	@Override
	public Result getKlines(String symbol, String period, Long startTime, Long limit) {
		return executeSync(HxApiService.getKlines(symbol, period, startTime, limit));
	}

	@Override
	public Result getBalances() {
		return executeSync(HxApiService.getBalances());
	}

	@Override
	public Result getListenKey() {
		return executeSync(HxApiService.getListenKey());
	}

	@Override
	public Result expireListenKey() {
		return executeSync(HxApiService.expireListenKey());
	}

	@Override
	public Result delListenKey() {
		return executeSync(HxApiService.delListenKey());
	}

	@Override
	public Result getAddress(String coin) {
		return executeSync(HxApiService.getAddress(coin));
	}

	@Override
	public Result extract(String coin, String network, String address, String addressTag, String amount) {
		return executeSync(HxApiService.extract(coin, network, address, addressTag, amount));
	}

}
