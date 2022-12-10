package com.myblog.marminblog.controller;

import com.myblog.marminblog.dto.PostSaveDto;
import com.myblog.marminblog.dto.PostUpdateDto;
import com.myblog.marminblog.entity.PostEntity;
import com.myblog.marminblog.peristence.PostRepository;
import com.myblog.marminblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostApiController {
    @Autowired
    PostService service;
    @Autowired
    PostRepository repository;

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
        service.postUpdate(id,dto);
        return dto.getTitle() + dto.getContent() + id;
    }
    @DeleteMapping("/deletepost")
    public String delete(@RequestParam Long id){
       PostEntity entity = repository.findById(id).orElseThrow(()->
               new IllegalArgumentException("해당 게시글이 없습니다"));
       repository.delete(entity);
        return "게시글이 삭제되었습니다";
    }
}