package com.coinrui.api.impl;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.web.bind.annotation.RequestParam;

import com.hx.common.model.Result;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Hx's REST API URL mappings and endpoint security configuration.
 */
public interface CoinRuiApiService {

	/**
	 * 近期成交列表
	 * 
	 * @param coinCode
	 * @param limit
	 * @return
	 */
	@GET("/v1/market/recently_markets")
	Call<Result> recentlyMarkets(@Query("coinCode") String coinCode, @Query("limit") Integer limit);

	/**
	 * 查询历史成交
	 * 
	 * @param coinCode    币种code
	 * @param limit       范围数据，为空则返回默认500条
	 * @param orderInfoId
	 * @return
	 */
	@GET("/v1/market/history_markets")
	Call<Result> historyMarkets(@Query("coinCode") String coinCode, @Query("limit") Integer limit,
			@Query("orderInfoId") Long orderInfoId);

	/**
	 * 获取当前交易对平均价格（交易对的总价格/交易对的总数量）
	 * 
	 * @param symbol 交易对
	 * @return
	 */
	@GET("/v1/market/average_price")
	Call<Result> averagePrice(@Query("symbol") String symbol);

	/**
	 * 24hr 价格变动情况
	 * 
	 * @param symbol
	 * @return
	 */
	@GET("/v1/market/day_price")
	Call<Result> dayPrice(@Query("symbol") String symbol);

	/**
	 * 最新价格
	 * 
	 * @param symbol
	 * @return
	 */
	@GET("/v1/market/new_price")
	Call<Result> newPrice(@Query("symbol") String symbol);

	/**
	 * 当前最优挂单
	 * 
	 * @param symbol 交易对
	 * @return
	 */
	@GET("/v1/market/optimal_order")
	Call<Result> optimalOrder(@Query("symbol") String symbol);

	/**
	 * 获取服务器时间
	 * 
	 * @return
	 */
	@GET("/v1/market/server_time")
	Call<Result> serverTime();

	/**
	 * 获取交易规则和交易对信息
	 * 
	 * @return
	 */
	@GET("/v1/market/transaction_specification")
	Call<Result> transactionSpecification();

	/**
	 * 获取深度信息
	 * 
	 * @param symbol 交易对
	 * @param limit
	 * @return
	 */
	@GET("/v1/market/depth_info")
	Call<Result> depthInfo(@Query("symbol") String symbol, @Query("limit") Integer limit);

	/**
	 * 测试服务器连通性
	 * 
	 * @return
	 */
	@GET("/v1/market/server_connected")
	Call<Result> isServerConnected();

	/**
	 * 获取所有币信息
	 *
	 * @return
	 */
	@GET("/v1/wallet/getall_coininfo")
	Call<Result> getAllCoinInfo();

	/**
	 * 查询资产快照
	 *
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @param limit     返回条数
	 * @return
	 */
	@GET("/v1/wallet/assets_snapshot")
	Call<Result> assetsSnapshot(@Query("startTime") String startTime, @Query("endTime") String endTime,
			@Query("limit") Integer limit);

	/**
	 * 
	 * @param coin      币种
	 * @param startTime 时间段from
	 * @param endTime   时间段to
	 * @return
	 */
	@GET("/v1/wallet/charge/history/list")
	Call<Result> getChargeHistroy(@Query("coin") String coin, @Query("startTime") String startTime,
			@Query("endTime") String endTime);

	/**
	 * 
	 * @param coin      提币币种
	 * @param status    提币状态
	 * @param offset    第几页
	 * @param limit     每页限制多少数据
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return
	 */
	@GET("/v1/wallet/extract/history/list")
	Call<Result> getExtractHistroy(@Query("coin") String coin, @Query("status") String status,
			@Query("offset") String offset, @Query("limit") String limit, @Query("startTime") String startTime,
			@Query("endTime") String endTime);

	/**
	 * 查询用户账户状态
	 * 
	 * @return
	 */
	@GET("/v1/manage/account/status")
	Call<Result> getCoinAccountStatu();

	/**
	 * 查询币对买卖方交易费率
	 * 
	 * @return
	 */
	@GET("/v1/market/coinpair/trade/fee")
	Call<Result> getCoinPairFee();

	/**
	 * 查询全币对行情
	 * 
	 * @return
	 */
	@GET("/v1/market/coinpair/all/ticker")
	Call<Result> getAllKeypairTicker();

	@GET("/v1/entrust/order")
	Call<Result> getOrder(@Query("symbol") String symbol, @Query("clientOrderId") String clientOrderId);

	@GET("/v1/entrust/open_order")
	Call<Result> getOpenOrders(@Query("symbol") String symbol);

	@GET("/v1/entrust/all")
	Call<Result> getAllOrders(@Query("symbol") String symbol, @Query("startTime") Long startTime,
			@Query("endTime") Long endTime, @Query("limit") Long limit);

	@GET("/v1/entrust/history")
	Call<Result> getHistoryOrders(@Query("coin") String coin, @Query("status") Long status,
			@Query("offset") Long offset, @Query("limit") Long limit);

	@DELETE("/v1/entrust/order")
	Call<Result> delOrder(@Query("symbol") String symbol, @Query("clientOrderId") String clientOrderId);

	@POST("/v1/entrust/order")
	Call<Result> order(@Query("symbol") String symbol, @Query("type") Integer type,
			@Query("entrustPrice") String entrustPrice, @Query("entrustCount") String entrustCount,
			@Query("entrustWay") String entrustWay, @Query("stopPrice") String stopPrice,
			@Query("newClientOrderId") String newClientOrderId, @Query("newOrderRespType") String newOrderRespType);

	@GET("/v1/kline/klines")
	Call<Result> getKlines(@Query("symbol") String symbol, @Query("period") String period,
			@Query("startTime") Long startTime, @Query("limit") Long limit);
	
	@GET("/v1/account/balances")
	Call<Result> getBalances();
	
	@GET("/v1/account/listen_key")
	Call<Result> getListenKey();
	
	@PUT("/v1/account/listen_key")
	Call<Result> expireListenKey();
	
	@DELETE("/v1/account/listen_key")
	Call<Result> delListenKey();
	
	@GET("/v1/wallet/address")
	Call<Result> getAddress(@Query("coin")String coin);
	
	@GET("/v1/wallet/extract")
	Call<Result> extract(@Query("coin") String coin,
			@Query("network") String network,
			@Query("address") String address,
			@Query("addressTag") String addressTag,
			@Query("amount") String amount);

}
