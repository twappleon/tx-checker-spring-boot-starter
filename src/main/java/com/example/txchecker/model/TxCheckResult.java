package com.example.txchecker.model;

import java.math.BigDecimal;

/**
 * 交易检查结果类
 * 用于存储交易检查的结果信息，包括是否成功、消息、区块号等
 */
public class TxCheckResult {
    /**
     * 检查是否成功
     */
    private boolean success;

    /**
     * 结果消息
     */
    private String message;

    /**
     * 区块号
     */
    private String blockNumber;

    /**
     * 实际接收地址
     */
    private String realToAddress;

    /**
     * 实际交易金额
     */
    private BigDecimal realAmount;

    /**
     * 构造函数
     * @param success 检查是否成功
     * @param message 结果消息
     * @param blockNumber 区块号
     * @param realToAddress 实际接收地址
     * @param realAmount 实际交易金额
     */
    public TxCheckResult(boolean success, String message, String blockNumber, String realToAddress, BigDecimal realAmount) {
        this.success = success;
        this.message = message;
        this.blockNumber = blockNumber;
        this.realToAddress = realToAddress;
        this.realAmount = realAmount;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public String getBlockNumber() { return blockNumber; }
    public String getRealToAddress() { return realToAddress; }
    public BigDecimal getRealAmount() { return realAmount; }
}
