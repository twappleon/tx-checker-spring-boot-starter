# TX Checker Spring Boot Starter

一个用于检查区块链代币交易的 Spring Boot Starter，支持以太坊（ETH）和波场（TRON）网络。

## 功能特性

- 支持以太坊 ERC20 代币交易检查
- 支持波场 TRC20 代币交易检查
- 可配置的重试机制
- 简单易用的 API

## 安装

在您的 `pom.xml` 中添加以下依赖：

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>tx-checker-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 配置

在您的 `application.yml` 或 `application.properties` 中添加以下配置：

```yaml
tx-checker:
  web3-url: https://mainnet.infura.io/v3/your-api-key  # 以太坊节点URL
  tron-api-url: https://api.trongrid.io                 # 波场API URL
  retry-max-attempts: 3                                 # 最大重试次数
  retry-interval-millis: 2000                          # 重试间隔（毫秒）
```

## 使用方法

### 1. 注入 TokenTransactionChecker

```java
@Autowired
private TokenTransactionChecker tokenTransactionChecker;
```

### 2. 创建交易检查请求

```java
TokenTransaction tx = new TokenTransaction();
tx.setChain(ChainType.ETH);                    // 或 ChainType.TRON
tx.setTxHash("0x...");                         // 交易哈希
tx.setTokenContract("0x...");                  // 代币合约地址
tx.setToAddress("0x...");                      // 接收地址
tx.setExpectedAmount(new BigDecimal("1.0"));   // 预期金额
tx.setTokenDecimals(18);                       // 代币精度
```

### 3. 检查交易

```java
TxCheckResult result = tokenTransactionChecker.confirm(tx);
if (result.isSuccess()) {
    System.out.println("交易成功！");
    System.out.println("区块号: " + result.getBlockNumber());
    System.out.println("实际接收地址: " + result.getRealToAddress());
    System.out.println("实际金额: " + result.getRealAmount());
} else {
    System.out.println("交易检查失败: " + result.getMessage());
}
```

## 配置说明

| 配置项 | 说明 | 默认值 |
|--------|------|--------|
| tx-checker.web3-url | 以太坊节点URL | 必填 |
| tx-checker.tron-api-url | 波场API URL | 必填 |
| tx-checker.retry-max-attempts | 最大重试次数 | 3 |
| tx-checker.retry-interval-millis | 重试间隔（毫秒） | 2000 |

## 注意事项

1. 确保提供的节点URL是可用的
2. 对于以太坊网络，建议使用 Infura 或 Alchemy 等可靠的节点服务
3. 对于波场网络，可以使用官方API或第三方节点服务
4. 代币精度（decimals）必须正确设置，否则可能导致金额计算错误

## 示例代码

### 以太坊 ERC20 交易检查

```java
TokenTransaction tx = new TokenTransaction();
tx.setChain(ChainType.ETH);
tx.setTxHash("0x123...");
tx.setTokenContract("0x456...");
tx.setToAddress("0x789...");
tx.setExpectedAmount(new BigDecimal("1.0"));
tx.setTokenDecimals(18);

TxCheckResult result = tokenTransactionChecker.confirm(tx);
```

### 波场 TRC20 交易检查

```java
TokenTransaction tx = new TokenTransaction();
tx.setChain(ChainType.TRON);
tx.setTxHash("123...");
tx.setTokenContract("456...");
tx.setToAddress("789...");
tx.setExpectedAmount(new BigDecimal("1.0"));
tx.setTokenDecimals(6);

TxCheckResult result = tokenTransactionChecker.confirm(tx);
```

## 许可证

MIT License 