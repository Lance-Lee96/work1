package com.example.demo.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//테스트에 필요한 의존성을 대신 제공
public class ComputerTest2 {
	
	@Autowired //@Qualifier("Desktop")
	Computer computer;//주입을 해주려고 할텐데 이자리에 Desktop, Laptop 모두 올 수 있다.
	
	@Test
	public void widthTest() {
		System.out.println(computer.getScreenWidth());
	}
}

/*
 * 스프링이 객체를 어떻게 저장하는가?
 	@SpringBootApplication 어노테이션에 속해있는 @ComponentScan 어노테이션이 
 	해당 파일 아래 경로에 있는 모든 패키지를 탐색하면서 
 	@Component 어노테이션이 붙어있는 클래스를 모두 Map 형태로 저장한다.
 	
 	클래스 이름의 첫글자를 소문자화 해서 key로 저장 ex) Computer -> computer
 	객체를 value로 만들어서 저장
 	
 	의존성 주입(Dependency Injection)
 	객체를 필요로 할 때 스프링이 자동으로 주입을 해준다.
 	
 	1. 필드주입
 	
 	@Autowired
 	멤버
 	
 	2. 생성자 주입(99% 이 방법을 사용한다고 생각하면 된다.)
 	멤버
 	
 	public 생성자(멤버){
 		this.멤버 = 멤버
 	}
 	
 	3. 
 	
 */
