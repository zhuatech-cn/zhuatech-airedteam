/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.airedteam;
import org.junit.jupiter.api.Test;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;import org.springframework.http.MediaType;import org.springframework.test.web.servlet.MockMvc;import java.nio.charset.StandardCharsets;import java.util.Base64;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc class AiRedTeamApiIntegrationTests{
 @Autowired MockMvc mvc;private String auth(){return "Basic "+Base64.getEncoder().encodeToString("admin:test-admin".getBytes(StandardCharsets.UTF_8));}
 @Test void redTeamCanRunCoveredCampaignAndPersistAudit()throws Exception{String body="""
 {"requestId":"API-RT-1","userInputs":["请总结企业制度"],"modelOutputs":["依据制度给出摘要"],"toolTraces":["search:policy"],"executedScenarioCount":20,"requiredScenarioCount":20,"securityOwnerReviewed":true,"testerId":"tester","approverId":"approver"}
 """;mvc.perform(post("/api/ai-redteam/campaigns/run").header("Authorization",auth()).contentType(MediaType.APPLICATION_JSON).content(body)).andExpect(status().isOk()).andExpect(jsonPath("$.data.decision").value("PASS")).andExpect(jsonPath("$.data.coverage").value(1.0)).andExpect(jsonPath("$.data.auditId").isNumber());}
 @Test void anonymousAuditAccessIsDenied()throws Exception{mvc.perform(get("/api/ai-redteam/audits")).andExpect(status().isUnauthorized());}
}
