package com.example.insighthub.markdown;

import com.example.insighthub.markdown.service.DefaultMarkdownService;
import com.example.insighthub.markdown.service.MarkdownService;
import com.example.insighthub.markdown.service.impl.FormatMarkdownService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarkdownAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "insighthub.markdown", name = "enabled", havingValue = "true")
    public MarkdownService formatMarkdownService() {
        return new FormatMarkdownService();
    }
    @Bean
    @ConditionalOnMissingBean
    public MarkdownService defaultMarkdownService() {
        return new DefaultMarkdownService();
    }

}
