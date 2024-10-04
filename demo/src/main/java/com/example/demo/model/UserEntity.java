package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames="username")})
// 테이블에서 username 컬럼에 유니크제약조건을 설정한다.
// 동일한 username 을 가진 유저는 생성될 수 없다.
public class UserEntity {
	
	@Id // JPA에서 id필드가 테이블의 Primary Key임을 나타낸다.
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id; // 유저에게 고유하게 부여되는 id, uuid 로 생성된다.
	private String username; // 아이디로 사용할 유저 네임. 이메일 형식으로 만들자.
	private String password; // 비밀번호
	private String role; // 유저의 권한(관리자, 일반사용자)
	private String authProvider; // OAuth 소셜로그인시 사용할 유저 정보 제공자
}
