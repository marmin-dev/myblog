package com.myblog.marminblog.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String content;
}
