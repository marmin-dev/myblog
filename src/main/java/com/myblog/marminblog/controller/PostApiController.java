package com.myblog.marminblog.controller;

import com.myblog.marminblog.dto.PostJoinDto;
import com.myblog.marminblog.dto.PostSaveDto;
import com.myblog.marminblog.dto.PostUpdateDto;
import com.myblog.marminblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostApiController {
    @Autowired
    PostService service;

    @PostMapping("/postsave") //postsave http JSON타입으로 POST요청시 SQL로 저장
    public Long save(@RequestBody PostSaveDto dto){ //받아온 JSON타입을 Dto로 저장
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
    @PutMapping("/getupdate")
    public String update(@RequestParam Long id, @RequestBody PostUpdateDto dto){
        return dto.getTitle() + dto.getContent() + id;
    }

}
