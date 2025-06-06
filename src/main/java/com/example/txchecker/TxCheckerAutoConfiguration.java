package com.example.txchecker;

import com.example.txchecker.checker.TokenTransactionChecker;
import com.example.txchecker.config.TxCheckerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类，用于配置交易检查器的相关Bean
 * 该类负责创建TokenTransactionChecker实例并配置相关属性
 */
@Configuration
@EnableConfigurationProperties(TxCheckerProperties.class)
public class TxCheckerAutoConfiguration {

    /**
     * 创建TokenTransactionChecker实例
     * @param properties 交易检查器配置属性
     * @return TokenTransactionChecker实例
     */
    @Bean
    @ConditionalOnMissingBean
    public TokenTransactionChecker tokenTransactionChecker(TxCheckerProperties properties) {
        return new TokenTransactionChecker(properties);
    }
}
