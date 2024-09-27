package com.example.demo.presistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoEntity;

//JpaRepository<T, ID> jpa에서 제공하는 인터페이스
//T : 테이블에 매핑될 Entity클래스
//ID : 기본기의 타입
@Repository//@Component의 자식 컴포넌트, 컴포넌트 스캔시 Bean으로 생성됨
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
	
	//기본쿼리가 아닌 쿼리는 어떻게 처리해야할까?
	//JPA가 메서드의 이름을 파싱해서 SELECT * FROM Todo WHERE userId = '{userId}'와 같은
	//쿼리를 작성해서 실행해준다.
	//?1 : 메서드의 매개변수 순서 위치
	@Query("SELECT * FROM TodoEntity t WHERE t.userId= ?1")
	List<TodoEntity> findByUserId(String userId);
	
	
}

/* 
 싱글톤 패턴
 객체를 한번만 만들어놓고 계속 갖다 쓰겠다.
 스프링에서 Bean으로 만드는 것들은 다 싱글톤으로 만들어진다.
 메모리에 딱 1번만 올라게게 되고 우리는 만들어진 것을 사용한다.
  */

/*
 서비스 개발 실습
 POST 로 요청했을 때 CREATE REST API 개발
 GET으로 요청했을 때 RETRIEVE(검색) REST API 개발
 UPDATE로 요청했을 때 UPDATE REST API 개발
 DELETE로 요청했을 때 DELETE REST API 개발
 
 영속 계층 -> 서비스계층 -> 표현계층 순으로 구현
 */
 