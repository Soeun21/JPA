package org.example.main;

import org.example.Address;
import org.example.Member;
import org.example.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMainEmbedded {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {


            Address address = new Address("city","street","10000");
            Address address2 = new Address("city","street","10000");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAdress(address);
            em.persist(member1);

            // setter가 없기 떄문에 값을 새로 넣어줘야 한다
            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
            member1.setHomeAdress(newAddress);
//            // 임베디드 값 타입을 복사해서 사용할경우에는 값을 변경해도 함께 바뀌지 않는다.
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAdress(copyAddress);
//            em.persist(member2);

            // 임베디드 값타입을 여러 엔티티에서 공유했기 떄문에 하나의 객체에서 변경해도 모두 변경됨
//            member1.getHomeAdress().setCity("newCity"); 그걸 막기위해 setter을 생성하지 않는다

            System.out.println("member1 = "+ member1.getHomeAdress().getCity());
//            System.out.println("member2 = "+ member2.getHomeAdress().getCity());
            
            // equals를 재정의해서 비교해야한다
            System.out.println("address equals address2 = " + address.equals(address2));
            System.out.println("address == address2 = " + (address==address2));
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }


}
