/*
package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain4 {
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
            // Dirty Checking을 통해 변경사항 확인
            Member member = em.find(Member.class, 150L);
            member.setName("ㅁㅁㅁ");
//            JPA는 값을 바꾸면 트랜잭션이 커밋되는 시점에 업데이트가 반영된다
//            아래 코드를 안써도 됨
      */
/*      if(member.getName().equals("ㅁㅁㅁ")){
                em.update(member); // 내용이 같으면 업데이트
            }*//*


//            em.persist(member);    사용안함

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
