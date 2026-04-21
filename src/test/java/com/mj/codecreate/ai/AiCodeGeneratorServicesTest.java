package com.mj.codecreate.ai;

import com.mj.codecreate.ai.model.HtmlCodeResult;
import com.mj.codecreate.ai.model.MultiFileCodeResult;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorServicesTest {

    @Resource
    public AiCodeGeneratorServices aiCodeGeneratorServices;

    @Test
    void generatorHtmlCode() {
        HtmlCodeResult aiResult = aiCodeGeneratorServices.generatorHtmlCode("做个hellow word 页面展示。就写个200行代码");
        Assertions.assertNotNull(aiResult);
    }

    @Test
    void generatorMultiFileCode() {
        MultiFileCodeResult aiResult = aiCodeGeneratorServices.generatorMultiFileCode("做个留言板，简单点");
        Assertions.assertNotNull(aiResult);
    }
}