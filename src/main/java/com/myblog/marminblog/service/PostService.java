package com.myblog.marminblog.service;

import com.myblog.marminblog.dto.PostJoinDto;
import com.myblog.marminblog.dto.PostSaveDto;
import com.myblog.marminblog.dto.PostUpdateDto;
import com.myblog.marminblog.entity.PostEntity;
import com.myblog.marminblog.peristence.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    PostRepository repository;

    @Transactional
    public Long postSave(PostSaveDto dto){
        return repository.save(dto.toentity(dto)).getId();
    }
    @Transactional
    public List<String> postJoin(){
        List<PostJoinDto> dtoList = repository.findAllDesc().stream()
                .map(PostJoinDto::new).collect(Collectors.toList());
        List<String> strList = new ArrayList<>();
        for(PostJoinDto dto: dtoList){
            String str = "{" + dto.getTitle() + "," +dto.getAuthor()+
            "," +dto.getContent() +"},";
            strList.add(str);
        }
        return strList;
    }
    @Transactional
    public void postUpdate(Long id, PostUpdateDto dto){
        PostEntity entity = repository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("존재하지 않는 글입니다"));
        entity.update(dto.getTitle(), dto.getContent());
    }

}
