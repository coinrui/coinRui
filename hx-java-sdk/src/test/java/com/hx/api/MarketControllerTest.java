package com.hx.api;

import com.coinrui.api.CoinRuiApiClientFactory;
import com.hx.common.model.Result;
import org.junit.Test;

/**
 * Copyright:   coinrui.com
 *
 * @author: 颜小杰
 * @version: V1.0
 * @Date: 2020年4月19日
 */
public class MarketControllerTest {

    private String apiKey = "68071c8b0cc844e89b561cd37d90000e2afa4973ac9e4414be70a21e96209473";
    private String secret = "60951c68ca19466db9ff6ac72fc46617a957f782ea3f4b11a59ed4c13a44ea6e";

    /**
     * 近期成交列表
     */
    @Test
    public void recentlyMarkets(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().recentlyMarkets("BTC",30);
        System.out.println(result);
    }

    /**
     * 查询历史成交
     */
    @Test
    public void historyMarkets(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().historyMarkets("BTC",30,0L);
        System.out.println(result);
    }

    /**
     * 获取当前交易对平均价格（交易对的总价格/交易对的总数量）
     */
    @Test
    public void averagePrice(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().averagePrice("XRP_USDT");
        System.out.println(result);
    }

    /**
     * 24hr 价格变动情况
     */
    @Test
    public void dayPrice(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().dayPrice("XRP_USDT");
        System.out.println(result);
    }

    /**
     * 最新价格
     */
    @Test
    public void newPrice(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().newPrice("XRP_USDT");
        System.out.println(result);
    }

    /**
     * 当前最优挂单
     */
    @Test
    public void optimalOrder(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().optimalOrder("XRP_USDT");
        System.out.println(result);
    }

    /**
     * 获取服务器时间
     */
    @Test
    public void serverTime(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().serverTime();
        System.out.println(result);
    }

    /**
     * 获取交易规则和交易对信息
     */
    @Test
    public void transactionSpecification(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().transactionSpecification();
        System.out.println(result);
    }

    /**
     * 获取深度信息
     */
    @Test
    public void depthInfo(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().depthInfo("XRP_USDT",null);
        System.out.println(result);
    }

    /**
     * 测试服务器连通性
     */
    @Test
    public void isServerConnected(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().isServerConnected();
        System.out.println(result);
    }

}
