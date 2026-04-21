package com.mj.codecreate.ai;

import com.mj.codecreate.ai.model.HtmlCodeResult;
import com.mj.codecreate.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.SystemMessage;
import reactor.core.publisher.Flux;

public interface AiCodeGeneratorServices {

    /**
     * 生成单文件代码
     * @param userMessage 用户输入
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generatorHtmlCode(String userMessage);

    /**
     * 生成多文件代码
     * @param userMessage 用户输入
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system.txt")
    MultiFileCodeResult generatorMultiFileCode(String userMessage);


    /**
     * 生成单文件代码 - 流式
     * @param userMessage 用户输入
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt-stream.txt")
    Flux<String> generatorHtmlCodeStream(String userMessage);

    /**
     * 生成多文件代码 - 流式
     * @param userMessage 用户输入
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt-stream.txt")
    Flux<String> generatorMultiFileCodeStream(String userMessage);
}
