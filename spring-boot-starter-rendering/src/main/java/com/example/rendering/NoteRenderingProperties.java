package com.example.rendering;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "insighthub.rendering")
public class NoteRenderingProperties {

    private Boolean enabled = true;
    private int maxLength = 2000;

}
