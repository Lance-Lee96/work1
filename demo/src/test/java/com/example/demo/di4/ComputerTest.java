package com.example.demo.di4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComputerTest {
	
	@Autowired
	Coding coding; //스프링이 ComponentScan을 해서 만든 객체를 주입해준다.
	
	@Test
	public void computerTest() {
		
		System.out.println(coding.getComputer().getRam());
		
	}

}
/*
 * 의존성 주입을 할 수 있는 세가지 방법
 1. 필드 주입
 @Autowired를 붙힌다.
 순환참조시 오류가 발생하지 않기 때문에 stackOverflow가 일어날 수 있다
 
 순환참조
 Bean간의 참조 관계가 순환되어 발생하는 상황
 A클래스가 B클래스의 빈을 주입받고, B클래스가 A클래스의 빈을 주입받는 상황
 
 2. 생성자 주입
 생성자를 통해 객체를 주입받는다.
 
 
 class Person{
 	String name;
 	int age;
 	
 	public Person(String name, int age){
 		this.name = name;
 		this.age = age;
 	}
 
 3. setter주입
 - setter메서드를 통해 객체를 주입받는다.
 
 
 */
 