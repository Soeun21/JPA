package org.example;

import jpabook.Member;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMainProxy {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {


            Member member1 = new Member();
            member1.setName("hello");
            em.persist(member1);


            em.flush();
            em.clear();

//            영속성 컨텍스트에 찾는 엔티티가 이미 있으면 em.getReference()를 호출해도 실제 엔티티 반환
//            Member m1 = em.find(Member.class,member1.getId());
//            Member m2 = em.find(Member.class,member2.getId());
//            Member m3 = em.getReference(Member.class,member1.getId());
//            Member m4 = em.getReference(Member.class,member2.getId());
//
//            logic(m1,m2,m3,m4);

//            Member findMember = em.find(Member.class,member.getId());
            Member findMember = em.getReference(Member.class,member1.getId());// 프록시 객체 조회
            System.out.println("findMember = " + findMember.getClass());    // Proxy
//            System.out.println("findMember.getId = " + findMember.getId());
            Hibernate.initialize(findMember);// 강제초기화
//            System.out.println("findMember.getName = " + findMember.getName());// 강제 호출
//            System.out.println("findMember.getName = " + findMember.getName());// 초기화 완료된 프록시 객체기 때문에 쿼리없이 바로 조회가능

////            em.detach(findMember);// 영속성컨텍스트에서 findMember을 관리하지 않는다
//            em.clear();
//
//            // 영속성컨텍스트에 있는 findMember이 날라가기 때문에 출력되지 않는다.
//            // org.hibernate.LazyInitializationException
//            System.out.println("findMember.getName = " + findMember.getName());

            System.out.println("findMember.getName = " + findMember.getName());// 프록시가 불러와졌다면   -- getName을 하지않아서 안불러와졌으면
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(findMember));// 트루     -- false

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(Member m1, Member m2, Member m3, Member m4) {
        System.out.println("m1.getClass() = " + m1.getClass());
        System.out.println("m2.getClass() = " + m2.getClass());
        System.out.println("m3.getClass() = " + m3.getClass());
        System.out.println("m4.getClass() = " + m4.getClass());
        System.out.println("m1 == m2 " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 == m3 " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 " + (m1 instanceof Member));
        System.out.println("m2 " + (m2 instanceof Member));
        System.out.println("m3 " + (m3 instanceof Member));
        System.out.println("m1 == m4 " + (m1 == m4));
        System.out.println("m3 == m4 " + (m3 == m4));
        System.out.println("m1 == m3 " + (m1 == m3));

        System.out.println("m1 == m3 " + ((m1 instanceof Member)==(m3 instanceof Member)));
        System.out.println("m1 " + m1.getClass());
        System.out.println("m3 " + m3.getClass());
    }


}
