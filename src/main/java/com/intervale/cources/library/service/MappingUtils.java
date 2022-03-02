package com.intervale.cources.library.service;

import com.intervale.cources.library.model.Books;
import com.intervale.cources.library.model.BooksDto;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {
    public BooksDto mapToBooksDto(Books entity){
        BooksDto dto = new BooksDto();
        dto.setId(entity.getId());
        dto.setIsbn(entity.getIsbn());
        dto.setName(entity.getName());
        dto.setAuthor(entity.getAuthor());
        dto.setWeight(entity.getWeight());
        dto.setPages(entity.getPages());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public Books mapToBooksEntity(BooksDto dto){
        Books entity = new Books();
        entity.setId(dto.getId());
        entity.setIsbn(dto.getIsbn());
        entity.setName(dto.getName());
        entity.setAuthor(dto.getAuthor());
        entity.setWeight(dto.getWeight());
        entity.setPages(dto.getPages());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}
