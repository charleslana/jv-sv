package com.example.jv_sv.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jv_sv.exception.BusinessException;
import com.example.jv_sv.model.dto.UserDTO;
import com.example.jv_sv.model.dto.UserUpdateDTO;
import com.example.jv_sv.model.entity.UserEntity;
import com.example.jv_sv.model.mapper.UserMapper;
import com.example.jv_sv.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CounterService counterService;

    public UserDTO create(UserDTO dto) {
        validateUser(dto);
        Long userId = counterService.generateId("userId");
        UserEntity entity = mapper.toEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setUserId(userId);
        entity.setName(generateName());
        UserEntity savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    public UserDTO update(UserUpdateDTO dto) {
        UserEntity existingEntity = repository.findByUserId(dto.getUserId());
        if (existingEntity == null) {
            throw new BusinessException("Usuário não encontrado.");
        }
        if (!existingEntity.getName().equals(dto.getName()) &&
                repository.findByName(dto.getName()) != null) {
            throw new BusinessException("Nome já está em uso.");
        }
        existingEntity.setName(dto.getName());
        repository.save(existingEntity);
        return mapper.toDto(existingEntity);
    }

    public UserDTO getByUserId(Long userId) {
        UserEntity entity = repository.findByUserId(userId);
        if (entity == null) {
            throw new BusinessException("Usuário não encontrado.");
        }
        return mapper.toDto(entity);
    }

    public List<UserDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    private void validateUser(UserDTO dto) {
        if (repository.findByEmail(dto.getEmail()) != null) {
            throw new BusinessException("Email já está em uso.");
        }
        if (repository.findByName(dto.getName()) != null) {
            throw new BusinessException("Nome já está em uso.");
        }
    }

    private String generateName() {
        Long randomNumber = 1000000000L + new Random().nextLong(9000000000L);
        return "Player".concat(randomNumber.toString());
    }
}
