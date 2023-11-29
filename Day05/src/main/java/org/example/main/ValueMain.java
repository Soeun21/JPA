package org.example.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ValueMain {
    public static void main(String[] args) {
       Integer a = new Integer(10);
       Integer b = a;

       a = 20;

       System.out.println("a = " + a);
       System.out.println("b = " + b);


    }


    public static class JPAMainParent {
        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {


                tx.commit();
            }catch (Exception e){
                tx.rollback();

            }finally {
                em.close();
            }
            emf.close();
        }



    }
}
