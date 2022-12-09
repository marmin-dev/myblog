package com.myblog.marminblog.controller;

import com.myblog.marminblog.dto.PostJoinDto;
import com.myblog.marminblog.dto.PostSaveDto;
import com.myblog.marminblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostApiController {
    @Autowired
    PostService service;

    @PostMapping("/postsave")
    public Long save(@RequestBody PostSaveDto dto){
        return service.postSave(dto);
    }
    @GetMapping("/getpost")
    public String join(){
//        List<PostJoinDto> joindto = service.postJoin();
//        String str = joindto.toString();
//        System.out.println(str);
//        return str;
       List<String> strList = service.postJoin();
       return strList.toString();

    }

}
