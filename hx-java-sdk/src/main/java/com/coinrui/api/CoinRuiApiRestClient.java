package com.coinrui.api;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.web.bind.annotation.RequestParam;

import com.hx.common.model.Result;

import retrofit2.http.Query;

/**
 * Hx API façade, supporting synchronous/blocking access Hx's REST API.
 */
public interface CoinRuiApiRestClient {
	Result test1(String coinCode, Integer limit);

	/**
	 * 近期成交列表
	 * 
	 * @param coinCode
	 * @param limit
	 * @return
	 */
	Result recentlyMarkets(String coinCode, Integer limit);

	/**
	 * 查询历史成交
	 * 
	 * @param coinCode    币种code
	 * @param limit       范围数据，为空则返回默认500条
	 * @param orderInfoId
	 * @return
	 */
	Result historyMarkets(String coinCode, Integer limit, Long orderInfoId);

	/**
	 * 获取当前交易对平均价格（交易对的总价格/交易对的总数量）
	 * 
	 * @param symbol 交易对
	 * @return
	 */
	Result averagePrice(String symbol);

	/**
	 * 24hr 价格变动情况
	 * 
	 * @param symbol
	 * @return
	 */
	Result dayPrice(String symbol);

	/**
	 * 最新价格
	 * 
	 * @param symbol
	 * @return
	 */
	Result newPrice(String symbol);

	/**
	 * 当前最优挂单
	 * 
	 * @param symbol 交易对
	 * @return
	 */
	Result optimalOrder(String symbol);

	/**
	 * 获取服务器时间
	 * 
	 * @return
	 */
	Result serverTime();

	/**
	 * 获取交易规则和交易对信息
	 * 
	 * @return
	 */
	Result transactionSpecification();

	/**
	 * 获取深度信息
	 * 
	 * @param symbol 交易对
	 * @param limit
	 * @return
	 */
	Result depthInfo(String symbol, Integer limit);

	/**
	 * 测试服务器连通性
	 * 
	 * @return
	 */
	Result isServerConnected();

	/**
	 * 获取所有币信息
	 *
	 * @return
	 */
	Result getAllCoinInfo();

	/**
	 * 查询资产快照
	 *
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @param limit     返回条数
	 * @return
	 */
	Result assetsSnapshot(String startTime, String endTime, Integer limit);

	/**
	 * 
	 * @param coin      币种
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return
	 */
	Result getChargeHistroy(String coin, String startTime, String endTime);

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
	Result getExtractHistroy(String coin, String status, String offset, String limit, String startTime, String endTime);

	/**
	 * 查询用户账户状态
	 * 
	 * @return
	 */
	Result getCoinAccountStatu();

	/**
	 * 查询币对买卖方交易费率
	 * 
	 * @return
	 */
	Result getCoinPairFee();

	/**
	 * 查询所有币对行情
	 * 
	 * @return
	 */
	Result getAllKeypairTicker();

	/**
	 * 查询单个委托单
	 * 
	 * @return
	 */
	Result getOrder(String symbol, String clientOrderId);

	/**
	 * 查询当前挂单
	 * 
	 * @return
	 */
	Result getOpenOrders(String symbol);

	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	Result getAllOrders(String symbol, Long startTime, Long endTime, Long limit);

	/**
	 * 查询账户成交历史
	 * 
	 * @return
	 */
	Result getHistoryOrders(String symbol, Long startTime, Long endTime, Long limit);

	/**
	 * 撤单
	 * 
	 * @return
	 */
	Result delOrder(String symbol, String clientOrderId);

	/**
	 * 下单
	 * 
	 * @return
	 */
	Result order(String symbol, Integer type, String entrustPrice, String entrustCount, String entrustWay,
			String stopPrice, String newClientOrderId, String newOrderRespType);

	/**
	 * 获取K线数据
	 * 
	 * @return
	 */
	Result getKlines(String symbol, String period, Long startTime, Long limit);

	/**
	 * 获取账户余额
	 * 
	 * @return
	 */
	Result getBalances();

	/**
	 * 获取用户数据流
	 * 
	 * @return
	 */
	Result getListenKey();

	/**
	 * 刷新用户数据流
	 * 
	 * @return
	 */
	Result expireListenKey();

	/**
	 * 销毁用户数据流
	 * 
	 * @return
	 */
	Result delListenKey();

	/**
	 * 查询充值地址
	 * 
	 * @return
	 */
	Result getAddress(String coin);

	/**
	 * 申请提现
	 * 
	 * @return
	 */
	Result extract(String coin, String network, String address, String addressTag, String amount);
	
}