package ex1;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


//영속성 컨텍스트 - 엔터티를 영구 저장하는 환경
// EntityManager.persist(entity)
// 엔티티를 db에 저장하는게 아니라 영속성컨텍스트라는 곳에 저장하는 것
// 영속성 컨텍스트는 논리적인 개념으로 엔티티매니저를 통해 접근
// 엔티티메니저안에 영속성컨텍스트라는 보이지 않는 공간이 생기는 개념
public class Ex01 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 다대다 : 객체는 컬렉션을 사용해서 객체 2개로 다대다 관계 가능
            // 실무에서는 거의 사용하지 않는다

            tx.commit();
            System.out.println("===========commit==========");

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();

        }

        emf.close();
    }
}
