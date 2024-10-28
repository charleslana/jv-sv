package com.example.jv_sv.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.jv_sv.model.dto.UserDTO;
import com.example.jv_sv.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(UserEntity entity);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserEntity toEntity(UserDTO dto);
}
