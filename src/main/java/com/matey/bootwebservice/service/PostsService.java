package com.matey.bootwebservice.service;

import com.matey.bootwebservice.domain.Posts;
import com.matey.bootwebservice.domain.PostsRepository;
import com.matey.bootwebservice.domain.PostsRepositorySupport;
import com.matey.bootwebservice.web.dto.PostResponseDTO;
import com.matey.bootwebservice.web.dto.PostsListResponseDTO;
import com.matey.bootwebservice.web.dto.PostsSaveRequestDTO;
import com.matey.bootwebservice.web.dto.PostsUpdateRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final PostsRepositorySupport repositorySupport;

    public PostsService(PostsRepository postsRepository,
                        PostsRepositorySupport repositorySupport) {
        this.postsRepository = postsRepository;
        this.repositorySupport = repositorySupport;
    }

    @Transactional
    public Long save(PostsSaveRequestDTO requestDTO) {
        return postsRepository.save(requestDTO.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDTO) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No exists articles. id = " + id));

        posts.update(requestDTO.getTitle(), requestDTO.getContent());

        return id;
    }

    public PostResponseDTO findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No exists articles. id = " + id));

        return new PostResponseDTO(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findAllDesc() {
        return repositorySupport.findAllDesc()
                .stream()
                .map(PostsListResponseDTO::new)
                .collect(toList());
    }
}
