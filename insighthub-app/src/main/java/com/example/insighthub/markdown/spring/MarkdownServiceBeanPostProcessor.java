package com.example.insighthub.markdown.spring;

import com.example.insighthub.markdown.service.MarkdownService;
import com.example.insighthub.markdown.service.impl.DefaultMarkdownService;
import com.example.insighthub.markdown.service.impl.FormatMarkdownService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MarkdownServiceBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MarkdownService) {
            System.out.println("MarkdownService BEFORE init");
            if (bean instanceof DefaultMarkdownService) {
                System.out.println("DefaultMarkdownService BEFORE init");
            } else if (bean instanceof FormatMarkdownService) {
                System.out.println("FormatMarkdownService BEFORE init");
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MarkdownService) {
            System.out.println("MarkdownService AFTER init");
            if (bean instanceof DefaultMarkdownService) {
                System.out.println("DefaultMarkdownService AFTER init");
            }  else if (bean instanceof FormatMarkdownService) {
                System.out.println("FormatMarkdownService AFTER init");
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
