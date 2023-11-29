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
public class Ex02 {
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
//            단방향 연관관계

            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member1 member1 = new Member1();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            em.flush(); // 1캐시를 날려서 쿼리를 보내준다
            em.clear();// 영속성 컨텍스트 초기화

            Member1 findMember1 = em.find(Member1.class, member1.getId());

            Team findTeam = findMember1.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            Team newTeam = em.find(Team.class, 100L);
            findMember1.setTeam(newTeam);    // 팀을 수정할 수 있음

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
