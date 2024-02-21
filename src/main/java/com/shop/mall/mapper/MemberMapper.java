package com.shop.mall.mapper;

import com.shop.mall.dto.MemberDTO;
import com.shop.mall.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper extends GenericMapper<MemberDTO, Member> {
    MemberMapper instance = Mappers.getMapper(MemberMapper.class);
}
