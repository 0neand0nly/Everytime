package com.jj.spring.domian.posts;

import com.jj.spring.domain.posts.Posts;
import com.jj.spring.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PostsRepositoryTest")
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }


    @Test
    public void 게시글저장_불러오기() {

        String title="테스트 게시글";
        String content="콘텐츠";
        //given
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jy84570@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}