package com.example.txchecker.checker;

import com.example.txchecker.config.TxCheckerProperties;
import com.example.txchecker.model.ChainType;
import com.example.txchecker.model.TokenTransaction;
import com.example.txchecker.model.TxCheckResult;

/**
 * 代币交易检查器
 * 用于检查不同区块链上的代币交易状态
 */
public class TokenTransactionChecker {

    private final TxCheckerProperties props;

    /**
     * 构造函数
     * @param props 交易检查器配置属性
     */
    public TokenTransactionChecker(TxCheckerProperties props) {
        this.props = props;
    }

    /**
     * 确认交易状态
     * @param tx 代币交易信息
     * @return 交易检查结果
     */
    public TxCheckResult confirm(TokenTransaction tx) {
        if (tx.getChain() == ChainType.ETH) {
            return Web3Helper.checkERC20(tx, props.getWeb3Url());
        } else if (tx.getChain() == ChainType.TRON) {
            return TronHelper.checkTRC20(tx, props.getTronApiUrl());
        }
        return new TxCheckResult(false, "Unsupported chain", null, null, null);
    }
}
