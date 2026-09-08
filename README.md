# ZhuaTech AI Red Team｜企业 AI 红队安全平台

由 **[知华科技（上海如静知华信息科技有限公司）](https://www.zhuatech.cn/)** 发布，用于在 AI 应用上线前执行可重复、可审计的安全测试。

## 已实现的核心能力

- 检测中英文提示注入、系统提示泄露请求及指令优先级劫持。
- 检测 API Key、JWT、身份证、手机号、邮箱等敏感数据泄漏。
- 分析工具调用轨迹中的越权写入、任意命令、外发和凭据访问。
- 识别删除数据、转账、关闭安全控制等危险动作。
- 按严重度累计风险分，输出 `PASS / REMEDIATE / BLOCK`。
- 校验测试覆盖率、安全负责人复核和测试/审批职责分离。
- 为每个发现生成证据、规则编号和可执行修复建议。
- 活动请求幂等、结果持久化，管理员与审计员权限隔离。

## 接口

- `POST /api/ai-redteam/campaigns/run`：运行红队测试活动。
- `GET /api/ai-redteam/audits`：查询最近审计记录。

## 启动

```bash
cp .env.example .env
docker compose up --build
```

访问 `http://localhost:8094`。

> 只能对获得明确授权的模型和环境进行测试。本工程仅限个人非商业学习交流；企业使用和所有商业行为须取得上海如静知华信息科技有限公司书面授权，详见 [LICENSE](LICENSE)。

AI 安全评估、模型红队和私有化部署请联系[知华科技](https://www.zhuatech.cn/)。
