package yoon.test.restapi1.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yoon.test.restapi1.dto.MemberDto;
import yoon.test.restapi1.entity.Member;
import yoon.test.restapi1.repository.MemberRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDto find(Long id){
        Member member = memberRepository.findMemberById(id);
        return new MemberDto(member.getName(), member.getPassword());
    }
    @Transactional
    public MemberDto join(MemberDto dto) {

        Member member = Member.builder().
                name(dto.getName()).
                password(dto.getPassword()).
                build();

        memberRepository.save(member);

        return dto;
    }
    @Transactional
    public MemberDto update(Long id, MemberDto dto) {
        Member member = memberRepository.findMemberById(id);
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());
        return new MemberDto(dto.getName(), dto.getPassword());
    }
    @Transactional
    public void delete(Long id){
        Member member = memberRepository.findMemberById(id);
        memberRepository.delete(member);
    }
}
