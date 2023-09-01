package com.study.boardTwo.domain;

import lombok.Data;

@Data
public class Member {

    private Long id;         //회원 번호 pk
    private String loginId;  //로그인 ID
    private String password; // 비밀번호
}
