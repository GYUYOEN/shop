package com.shop.mall.mapper;

import com.shop.mall.dto.MemberDTO;
import com.shop.mall.entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T22:29:47+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDTO toDTO(Member entity) {
        if ( entity == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setUserId( entity.getUserId() );
        memberDTO.setEmail( entity.getEmail() );
        memberDTO.setName( entity.getName() );
        memberDTO.setPwd( entity.getPwd() );
        memberDTO.setPhone( entity.getPhone() );
        memberDTO.setGender( entity.getGender() );
        memberDTO.setAuthority( entity.getAuthority() );
        memberDTO.setCreatedDate( entity.getCreatedDate() );
        memberDTO.setUpdatedDate( entity.getUpdatedDate() );

        return memberDTO;
    }

    @Override
    public Member toEntity(MemberDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.userId( dto.getUserId() );
        member.email( dto.getEmail() );
        member.name( dto.getName() );
        member.pwd( dto.getPwd() );
        member.phone( dto.getPhone() );
        member.gender( dto.getGender() );
        member.authority( dto.getAuthority() );

        return member.build();
    }

    @Override
    public List<MemberDTO> toDTOList(List<Member> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MemberDTO> list = new ArrayList<MemberDTO>( entityList.size() );
        for ( Member member : entityList ) {
            list.add( toDTO( member ) );
        }

        return list;
    }

    @Override
    public List<Member> toEntityList(List<MemberDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Member> list = new ArrayList<Member>( dtoList.size() );
        for ( MemberDTO memberDTO : dtoList ) {
            list.add( toEntity( memberDTO ) );
        }

        return list;
    }

    @Override
    public void updateFromDTO(MemberDTO dto, Member entity) {
        if ( dto == null ) {
            return;
        }
    }
}
