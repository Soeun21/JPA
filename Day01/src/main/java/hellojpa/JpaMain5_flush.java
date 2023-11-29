/*
package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain5_flush {
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
            //영속상태

            Member member = new Member(200L, "mem200");
            em.persist(member); // 영속성컨텍스트에 담기고 쿼리가 저장된 상태  쿼리는 아직 안 날라감 DB조회안됨

            em.flush(); // 쿼리 실행
            // 1차 캐시는 유지된 상태로 영속성컨 텍스트의 쓰기지연 sql 저장소에 있는 것이 반영 되는 것
                
            System.out.println("=====================");
            //DB에 저장되는 단계
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();

        }

        emf.close();
    }
}
*/
