package com.myblog.marminblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class PostUpdateDto {
    public String title;
    public String content;


}
