package com.example.board.domain.dao;

import com.example.board.domain.vo.RestVO;
import com.example.board.mapper.RestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RestDAO {

    private final RestMapper restMapper;

    //    댓글 등록
    public void register(RestVO restVO){
        restMapper.insert(restVO);
    }
    //    댓글 1개 조회
    public RestVO read(Long restNumber){
        return restMapper.select(restNumber);
    }
    //    댓글 삭제
    public void remove(Long restNumber){
        restMapper.delete(restNumber);
    }
}
