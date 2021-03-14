package hi.hispring.service;

import hi.hispring.domain.Member;
import hi.hispring.repository.MemberRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberrepository;

    public MemberService(MemberRepository memberrepository) {
        this.memberrepository = memberrepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 동일 이름 회원 X
        validateDuplicateMember(member);
        memberrepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberrepository.findByName(member.getName())
            .ifPresent(m -> {
                 throw new IllegalStateException("이미 존재하는 회원입니다.");
             } );
    }

    public List<Member> findMembers() {
        return memberrepository.findAll();

    }

    public Optional<Member> findOne(Long memberId) {
        return memberrepository.findById(memberId);
    }


}
