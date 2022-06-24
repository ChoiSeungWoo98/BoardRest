package com.example.board.controller;

/*
 * REST(Representational State Transfer)
 *   하나의 URI는 하나의 고유한 리소스(데이터)를 대표하도록 설계된다.
 *   예)/board/123 : 게시글 중 123번 게시글의 전체 정보
 * */

import com.example.board.domain.vo.RestVO;
import com.example.board.service.RestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequestMapping("/rest/*")
@RequiredArgsConstructor
public class RestController {
    private final RestService restService;

    //5개
    //1번 매개변수 없고 리턴은 문자열
    @GetMapping("/noIndex")
    public String noIndex(){
        return "매개변수 없고 리턴은 문자열";
    }
    //2번 매개변수 1개 있고 리턴은 문자열
    @GetMapping("/{oneIndex}")
    public String oneIndex(@PathVariable("oneIndex") String oneIndex){
        return "매개변수 "+oneIndex+"가 있고 리턴은 문자열";
    }
    //3번 매개변수 없고 리턴은 JSON Object
    @GetMapping("/jsonObj")
    public RestVO jsonObj(){
        return restService.read(33L);
    }
    //4번 매개변수 여러 개 있고 리턴은 JSON Object
    @GetMapping("/two/{indexList}")
    public RestVO jsonObj(@PathVariable("indexList") Long[] indexList){
        Long to = indexList[0] > indexList[1] ? indexList[0]:indexList[1];
        return restService.read(to);
    }
    //5번 매개변수 여러 개 있고 리턴은 JSON Array
    @GetMapping("/five/{indexList}")
    public ArrayList<RestVO> jsonArr(@PathVariable("indexList") Long[] indexList){
        ArrayList<RestVO> list = new ArrayList<>();
        for (Long idx: indexList) {
            list.add(restService.read(idx));
        }
        return list;
    }
    //4개(DB 테이블 생성)
    //1번 매개변수 1개 있고 리턴은 문자열
    @GetMapping("/db/{oneIndex}")
    public String oIndex(@PathVariable("oneIndex") Long oneIndex){
        return "매개변수 "+restService.read(oneIndex).getRestTitle()+"가 있고 리턴은 문자열";
    }
    //2번 매개변수 없고 리턴은 JSON Object
    @GetMapping("/db/jsonObj")
    public RestVO pJsonObj(){
        return restService.read(33L);
    }
    //3번 매개변수 여러 개 있고 리턴은 JSON Object
    @GetMapping("/db/two/{indexList}")
    public RestVO pJsonObj(@PathVariable("indexList") Long[] indexList){
        Long to = indexList[0] > indexList[1] ? indexList[0]:indexList[1];
        return restService.read(to);
    }
    //4번 매개변수 여러 개 있고 리턴은 JSON Array
    @GetMapping("/db/five/{indexList}")
    public ArrayList<RestVO> pJsonArr(@PathVariable("indexList") Long[] indexList){
        ArrayList<RestVO> list = new ArrayList<>();
        for (Long idx: indexList) {
            list.add(restService.read(idx));
        }
        return list;
    }
    //Git 개인 레포지토리 push

}



















