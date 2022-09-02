package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component //컴포넌트 적용하면 기본이 앞글자 소문에 memoryMemberRepository가 된다.
public class MemoryMemberRepository implements MemberRepository{

    //HashMap이 동시성 이슈가 있을 수 있지만, 개발 용도로만 쓰고 넘어간다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
