package com.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/8/17 上午 09:52
 **/
@Mapper
public interface CatDogMapper {

    CatDogMapper INSTANCE = Mappers.getMapper(CatDogMapper.class);

    @Mappings({
            @Mapping(target = "catName", source = "dogName"),
            @Mapping(target = "testListCat", source = "testListDog")
    })
    Cat toCat(Dog dog);

    List<Cat> toCatList(List<Dog> dogList);
}
