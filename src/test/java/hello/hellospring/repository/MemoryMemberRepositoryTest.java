package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        //then
        Assertions.assertEquals(result,member);
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findByName() {
        //회원1
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        //회원2
        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    void findAll() {
        //회원1
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        //회원2
        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }
}