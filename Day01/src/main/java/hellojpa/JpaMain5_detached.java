/*
package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain5_detached {
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
            Member member = em.find(Member.class, 150L);
            member.setName("CCCC");

//            em.detach(member);// 영속성컨텍스트에서 떼어냈기 떄문에JPA에서 관리하지 않는다

            em.clear(); // 영속성컨텍스트를 완전히 통으로 초기화함

            Member member2 = em.find(Member.class, 150L);   // 영속성컨텍스트를 날리고 다시하기 떄문에
            // 셀렉트를 다시 한다

            System.out.println("=====================");
            //DB에 저장되는 단계
            tx.commit();    // JPA에서 관리하지 않기 때문에 커밋을 해도 변화가 없다. 업데이트 쿼리 실행 안함
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close(); // 영속성 컨텍스트를 종료

        }

        emf.close();
    }
}
*/
