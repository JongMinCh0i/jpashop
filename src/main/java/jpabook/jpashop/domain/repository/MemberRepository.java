package jpabook.jpashop.domain.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext // 영속성 컨텍스트
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    // 단건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id); // 타입 , PK
    }

    public List<Member> findAll() {
        //SQL은 테이블을 대상으로 쿼리, JPQL은 Entity(객체)를 대상으로 쿼리를 진행한다.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 이름에 의해서 조회하는 쿼리
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
