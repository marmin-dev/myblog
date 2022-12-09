package com.myblog.marminblog.dto;

import com.myblog.marminblog.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PostJoinDto {

    private Long id;
    private String title;
    private String author;
    private String content;

    public PostJoinDto(PostEntity entity){
        this.id = entity.getId();
        this.title =entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
    }
}
