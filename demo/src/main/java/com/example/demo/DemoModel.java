package com.example.demo;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@Data
public class DemoModel {
	
	@NonNull
	String id;
}

/*
 * @Getter getter메서드 만들어줌
 * @Setter setter메서드 만들어줌
 * @NoArgsConstructor 매개변수 없는 기본 생성자
 * @AllArgsConstructor 모든 멤버를 매개변수로 가지는 생성자 생성
 * @RequiredArgsConstructor final이나 @NonNull인 필드만 매개변수로 갖는 생성자 생성
 * @Data getter,setter,requiredArgsConstructor,ToString,EqualsAndHashCode를 한번에 정의
 * @Builder 빌더패턴을 사용할 수 있게 해주는 어노테이션

@Builder
public class User{
	private String id;
	private String name;
	private String email;
}

User user = User.builder().id("1").name("홍길동").email("hong@example.com").build()











*/