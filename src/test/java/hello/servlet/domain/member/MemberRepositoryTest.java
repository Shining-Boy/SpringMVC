package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hansam", 36);
        
        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member foundMember = memberRepository.findById(savedMember.getId());
        assertThat(foundMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("hansam", 36);
        Member member2 = new Member("hello", 20);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> memberList = memberRepository.findall();

        //then
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);
    }
}
