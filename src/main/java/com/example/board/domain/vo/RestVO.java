package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RestVO {
    private Long restNumber;
    private String restTitle;
    private String restContent;
}
