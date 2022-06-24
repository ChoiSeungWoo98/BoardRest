package com.example.board.service;

import com.example.board.domain.dao.RestDAO;
import com.example.board.domain.vo.RestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestService {

    private final RestDAO restDAO;

    //    댓글 등록
    public void register(RestVO restVO){
        restDAO.register(restVO);
    }
    //    댓글 1개 조회
    public RestVO read(Long restNumber){
        return restDAO.read(restNumber);
    }
    //    댓글 삭제
    public void remove(Long restNumber){
        restDAO.remove(restNumber);
    }
}
