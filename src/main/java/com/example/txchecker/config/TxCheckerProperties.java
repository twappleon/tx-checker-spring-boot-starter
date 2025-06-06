package com.example.txchecker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 交易检查器配置属性类
 * 用于配置Web3和Tron API的URL以及重试策略
 */
@ConfigurationProperties(prefix = "tx-checker")
public class TxCheckerProperties {
    /**
     * Web3节点的URL地址
     */
    private String web3Url;

    /**
     * Tron API的URL地址
     */
    private String tronApiUrl;

    /**
     * 最大重试次数
     */
    private int retryMaxAttempts = 3;

    /**
     * 重试间隔时间（毫秒）
     */
    private long retryIntervalMillis = 2000;

    public String getWeb3Url() {
        return web3Url;
    }

    public void setWeb3Url(String web3Url) {
        this.web3Url = web3Url;
    }

    public String getTronApiUrl() {
        return tronApiUrl;
    }

    public void setTronApiUrl(String tronApiUrl) {
        this.tronApiUrl = tronApiUrl;
    }

    public int getRetryMaxAttempts() {
        return retryMaxAttempts;
    }

    public void setRetryMaxAttempts(int retryMaxAttempts) {
        this.retryMaxAttempts = retryMaxAttempts;
    }

    public long getRetryIntervalMillis() {
        return retryIntervalMillis;
    }

    public void setRetryIntervalMillis(long retryIntervalMillis) {
        this.retryIntervalMillis = retryIntervalMillis;
    }
}
