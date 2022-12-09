package com.myblog.marminblog.controller;

import com.myblog.marminblog.dto.PostSaveDto;
import com.myblog.marminblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    @Autowired
    PostService service;

    @PostMapping("/postsave")
    public Long save(@RequestBody PostSaveDto dto){
        return service.postSave(dto);
    }

}
