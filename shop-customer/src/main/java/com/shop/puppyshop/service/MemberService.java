package com.shop.puppyshop.service;

import com.shop.puppyshop.member.entity.Member;
import com.shop.puppyshop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmailAndUserId(member.getEmail(),member.getUserId());
        if (findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다");
        }

    }
}
