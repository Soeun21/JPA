package org.example;

import jpabook.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMainLazy {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);
            Team team1 = new Team();
            team1.setName("team1");
            em.persist(team1);


            Member member1 = new Member();
            member1.setName("hello");
            member1.setTeam(team);
            em.persist(member1);
            Member member2 = new Member();
            member2.setName("member");
            member2.setTeam(team1);
            em.persist(member2);



            em.flush();
            em.clear();

            //EAGER : 즉시로딩을 사용하면 셀렉트문이 member, team모두 나간다
//            List<Member> memberList = em.createQuery("select m from Member  m",Member.class)
//                    .getResultList();
            // 엔티티에 지연로딩을 걸지않았을 경우 쿼리에서 지연로딩을 거는 방법
            List<Member> memberList = em.createQuery("select m from Member  m join fetch m.team",Member.class)
                    .getResultList();

//            Member m = em.find(Member.class,member1.getId());
//            //  실무에서는 가급적 지연 로딩만 사용할 것
//            // 지연로딩을 사용해서 proxy객체가 불러와진다
//            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
//
//            System.out.println("==================" );
//            m.getTeam().getName();// 초기화
//            System.out.println("m.getTeam() = " + m.getTeam());
//            System.out.println("m.TeamName = " + m.getTeam().getName());
//            System.out.println("==================" );

            tx.commit();
        }catch (Exception e){
            tx.rollback();

        }finally {
            em.close();
        }
        emf.close();
    }



}
