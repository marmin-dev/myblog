package com.myblog.marminblog.dto;

import com.myblog.marminblog.entity.PostEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostSaveDto {
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String content;

    public PostEntity toentity(PostSaveDto dto){ //Dto to Entity data transfer function
        PostEntity entity = new PostEntity(
                null,
                dto.getTitle(),
                dto.getAuthor(),
                dto.getContent());
        return entity;
    }

}
