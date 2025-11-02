package com.example.insighthub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private String id;
    private String title;
    private String content;
    private String author;
    private String createdAt;
}
