package com.example.board.mapper;

import com.example.board.domain.vo.RestVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RestMapper {
//    댓글 등록
    public void insert(RestVO restVO);
//    댓글 1개 조회
    public RestVO select(Long restNumber);
//    댓글 삭제
    public void delete(Long restNumber);
}
