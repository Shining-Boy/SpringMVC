package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤 클리스이기 때문에 외부 호출로 인한 객체 생성을 제한
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        member.setUsername("bae");
        member.setAge(36);
        store.put(member.getId(), member);

        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findall() {
        return new ArrayList<>(store.values()); //store에 대한 참조를 막아 내부 정보를 보호하기 위함
    }

    public void clearStore() {
        store.clear();
    }
}
