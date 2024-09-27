package com.example.demo.di4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//코딩을 하려면 컴퓨터가 필요하다.
@Component
//@RequiredArgsConstructor //생성자 생성
public class Coding {
	
//	@Autowired
//	private Computer computer;
	
	
	//final이나 @NonNull 붙이고
	private Computer computer;
	
	//생성자 주입(Constructor injection)
	//생성자가 호출되는 시점 -> 객체가 만들어질 때 매개변수에 객체가 주입이된다.
//	public Coding(Computer computer) {
//		this.computer = computer;
//	}
	
	
	//setter injection
	@Autowired
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public Computer getComputer() {
		return computer;
	}
}
