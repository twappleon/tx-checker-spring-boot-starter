package com.example.txchecker.model;

import java.math.BigDecimal;

/**
 * 代币交易信息类
 * 用于存储代币交易的相关信息，包括链类型、交易哈希、代币合约地址等
 */
public class TokenTransaction {
    /**
     * 区块链类型
     */
    private ChainType chain;

    /**
     * 交易哈希
     */
    private String txHash;

    /**
     * 代币合约地址
     */
    private String tokenContract;

    /**
     * 接收地址
     */
    private String toAddress;

    /**
     * 预期交易金额
     */
    private BigDecimal expectedAmount;

    /**
     * 代币精度
     */
    private int tokenDecimals;

    // Getters and Setters
    public ChainType getChain() { return chain; }
    public void setChain(ChainType chain) { this.chain = chain; }

    public String getTxHash() { return txHash; }
    public void setTxHash(String txHash) { this.txHash = txHash; }

    public String getTokenContract() { return tokenContract; }
    public void setTokenContract(String tokenContract) { this.tokenContract = tokenContract; }

    public String getToAddress() { return toAddress; }
    public void setToAddress(String toAddress) { this.toAddress = toAddress; }

    public BigDecimal getExpectedAmount() { return expectedAmount; }
    public void setExpectedAmount(BigDecimal expectedAmount) { this.expectedAmount = expectedAmount; }

    public int getTokenDecimals() { return tokenDecimals; }
    public void setTokenDecimals(int tokenDecimals) { this.tokenDecimals = tokenDecimals; }
}
