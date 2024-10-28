package com.example.jv_sv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.jv_sv.model.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    public UserEntity findByEmail(String email);

    public UserEntity findByName(String name);
    
    public UserEntity findByUserId(Long userId);
}
