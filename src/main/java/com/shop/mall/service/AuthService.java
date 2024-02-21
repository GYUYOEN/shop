package com.shop.mall.service;

import com.shop.mall.dto.MemberDTO;
import com.shop.mall.dto.TokenDTO;
import com.shop.mall.entity.Member;
import com.shop.mall.entity.RefreshToken;
import com.shop.mall.jwt.TokenProvider;
import com.shop.mall.mapper.MemberMapper;
import com.shop.mall.repository.RefreshTokenRepository;
import com.shop.mall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.shop.mall.entity.RefreshToken.*;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public MemberDTO signup(MemberDTO memberDTO) {
        if (memberRepository.existsByEmail(memberDTO.getEmail())) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        memberDTO.toPwdEncode(passwordEncoder);

        Member member = memberMapper.toEntity(memberDTO);
        memberRepository.save(member);

        return memberMapper.toDTO(member);
     }

     @Transactional
    public TokenDTO login(MemberDTO memberDTO) {
         UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberDTO.getEmail(), memberDTO.getPwd());

         Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

         TokenDTO tokenDTO = tokenProvider.generateTokenDto(authentication);

         RefreshToken refreshToken = builder()
                 .key(authentication.getName())
                 .value(tokenDTO.getRefreshToken()).build();

         refreshTokenRepository.save(refreshToken);

         return tokenDTO;
     }

     @Transactional
    public TokenDTO reissue(TokenDTO tokenDTO) {
        if(!tokenProvider.validateToken(tokenDTO.getRefreshToken())) {
            throw new RuntimeException("Refresh Token이 유효하지 않습니다.");
        }

        Authentication authentication = tokenProvider.getAuthentication(tokenDTO.getAccessToken());

        RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        if(!refreshToken.getValue().equals(tokenDTO.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        TokenDTO tokenNewDTO = tokenProvider.generateTokenDto(authentication);

        RefreshToken newRefreshToken = refreshToken.updateValue(tokenNewDTO.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        return tokenNewDTO;
     }
}
