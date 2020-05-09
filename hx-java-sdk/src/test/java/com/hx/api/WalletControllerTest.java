package com.hx.api;

import com.coinrui.api.CoinRuiApiClientFactory;
import com.hx.common.model.Result;
import org.junit.Test;

/**
 * Copyright:   coinrui.com
 *
 * @author: 颜小杰
 * @version: V1.0
 * @Date: 2020年4月12日
 */
public class WalletControllerTest {

    private String apiKey = "68071c8b0cc844e89b561cd37d90000e2afa4973ac9e4414be70a21e96209473";
    private String secret = "60951c68ca19466db9ff6ac72fc46617a957f782ea3f4b11a59ed4c13a44ea6e";

    /**
     * 获取所有币信息
     */
    @Test
    public void getAllCoinInfo(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().getAllCoinInfo();
        System.out.println(result);
    }

    /**
     * 查询资产快照
     */
    @Test
    public void assetsSnapshot(){
        CoinRuiApiClientFactory client = CoinRuiApiClientFactory.newInstance(apiKey, secret);
        Result result = client.newRestClient().assetsSnapshot("2020-04-10 00:00:00","2020-04-00 00:00:00",10);
        System.out.println(result);
    }
}
