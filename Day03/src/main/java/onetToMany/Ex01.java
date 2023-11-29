package onetToMany;



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
            /*
            일대다 단방향 매칭보다는 다대일 양방향 매핑을 사용하는 것을 권장한다
            Hibernate:  insert ex01.Member1
                insert into Member1 (TEAM_ID, USERNAME, MEMBER_ID) values (?, ?, ?)
            Hibernate:  insert ex01.Team
                insert into  Team (name, TEAM_ID) values (?, ?)
                
                연관관계 관리를 위해 추가로 update SQL실행
            Hibernate: create one-to-many row ex01.Team.member1s 
                update Member1 set TEAM_ID=? where MEMBER_ID=?
            */
            Member1 member1 = new Member1();
            member1.setUsername("member1");

            em.persist(member1);

            Team team  = new Team();
            team.setName("team");
            
            team.getMembers1().add(member1);

            em.persist(team);


            tx.commit();
            System.out.println("===========commit==========");

        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }

        emf.close();
    }
}
