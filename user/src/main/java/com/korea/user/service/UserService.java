package com.korea.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.persistence.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	
	public List<UserDTO> create(UserEntity entity){
		
		//사용자 생성
		//컨트롤러로부터 이름과 이메일이 담겨있는 Entity를 넘겨받는다.
		//db에 추가를 한 후, 추가가 잘 됐는지 조회를 한 데이터를 컨트롤러로 넘겨야 한다.
		repository.save(entity);//데이터베이스에 저장
		//List<UserEntity> -> List<UserDTO> 로 변환
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}
	
	public List<UserDTO> getAllUsers(){
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}
	
	public UserDTO getUserByEmail(String email){
		UserEntity entity = repository.findByEmail(email);
		return new UserDTO(entity);
	}
	
	public List<UserDTO> updateUser(UserEntity entity){
		//id를 통해서 db에 저장되어있는 객체를 찾는다.
		Optional<UserEntity> original = repository.findById(entity.getId());
		original.ifPresent(userEntity ->{
			//이름과 이메일을 객체에 setting을 한다.
			userEntity.setEmail(entity.getEmail());
			userEntity.setName(entity.getName());
			//업데이트된 사용자 정보 저장
			repository.save(userEntity);
		});
		return getAllUsers();
	}
	
	public boolean deleteUser(int id){
		//id를 통해 유저가 존재하는지 먼저 확인
		Optional<UserEntity> exist = repository.findById(id);
		
		if(exist.isPresent()) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
}
