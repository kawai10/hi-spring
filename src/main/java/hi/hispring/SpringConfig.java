package hi.hispring;

import hi.hispring.repository.Memberrepository;
import hi.hispring.repository.MemoryMemberRepository;
import hi.hispring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public Memberrepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
