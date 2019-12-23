package com.example.mapstruct.example.mapper;

import com.example.mapstruct.example.model.User;
import com.example.rules.v1.client.RulesUser;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "authorizedRoles", source = "authorizedRoles")
    User convertToUser(RulesUser rulesUser);

    /**
     * Map the user to the Proto User
     *
     * MapStruct does not currently supported proto3's map correctly.
     * Once supported we can remove the 2 mappings, https://github.com/mapstruct/mapstruct/issues/1343
     * @param user
     * @return
     */
    @Mapping(target = "attributes", ignore = true)
    RulesUser convertToRulesUser(User user);
}
