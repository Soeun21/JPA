/*
package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaEx01 {
    public static void main(String[] args) {
        //로딩 시점에 딱 하나만 만들어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //커넥션 객체
        EntityManager em = emf.createEntityManager();
        //jpa가 이루어지는 작업은 모두 transaction이 필요하다.
        EntityTransaction tx = em.getTransaction();
        //Transaction시작
        tx.begin();

        //try-catch-finally로 코드가 정상적으로 마지막까지 수행되게 처리해준다.
        //나중에는 spring이 알아서 해줌
        try{
        Member member = new Member();
            //비영속
         */
/*   member.setId(101L);
            member.setName("helloJPA");

            //영속(DB에 아직 저장되지 않음)
            System.out.println("===Before===");
            em.persist(member);
//            em.detach(member); //회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
            System.out.println("===After ===");

            Member findMember = em.find(Member.class, 101L);
            Member findMember1 = em.find(Member.class, 101L);
            //DB에 있는 정보를 가져오는게 아닌 Context에서 1차 캐시를 통해 조회함
            System.out.println("findMember = " + findMember.getName());
            System.out.println("findMember = " + findMember.getId());
            //DB로 데이터가 날아감*//*

            tx.commit();
            }
        catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }

        emf.close();
    }
}
*/
