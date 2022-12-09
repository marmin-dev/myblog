package com.myblog.marminblog.service;

import com.myblog.marminblog.dto.PostSaveDto;
import com.myblog.marminblog.peristence.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public Long postSave(PostSaveDto dto){
        return repository.save(dto.toentity(dto)).getId();
    }


}
