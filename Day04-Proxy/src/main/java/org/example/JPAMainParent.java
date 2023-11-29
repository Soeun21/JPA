package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMainParent {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Child child1 = new Child();
            Child child2 = new Child();
            Child child3 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);
            parent.addChild(child3);

            em.persist(parent);
            // cascade = CascadeType.ALL 를 하면 자식은 persist를 하지 않아도 자동으로 insert된다
            // cascade = CascadeType.ALL가 자동으로 persist를 해주는 것
//            em.persist(child1);
//            em.persist(child2);

            em.flush();
            em.clear();

            //orphanRemoval = true 연관관계가 끊긴 자식객체를 삭제한다
            Parent findParent = em.find(Parent.class,parent.getId());
            findParent.getChildList().remove(0);
//            em.remove(findParent);// 부모가 삭제되면 자식리스트도 다 사라진다


            tx.commit();
        }catch (Exception e){
            tx.rollback();

        }finally {
            em.close();
        }
        emf.close();
    }



}
