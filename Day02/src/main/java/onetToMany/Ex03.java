package onetToMany;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


//영속성 컨텍스트 - 엔터티를 영구 저장하는 환경
// EntityManager.persist(entity)
// 엔티티를 db에 저장하는게 아니라 영속성컨텍스트라는 곳에 저장하는 것
// 영속성 컨텍스트는 논리적인 개념으로 엔티티매니저를 통해 접근
// 엔티티메니저안에 영속성컨텍스트라는 보이지 않는 공간이 생기는 개념
public class Ex03 {
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
//            양방향 연관관계와 연관관계의 주인
            // 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자

            // 저장
            Team team = new Team();
            team.setName("TeamA");
            //역방향(주인이 아닌 방향)만 연관관계 설정
//            team.getMember1s().add(member1);
            em.persist(team);


            Member1 member1 = new Member1();
            member1.setUsername("member1");
//            양방향 매핑시 연관관계의 주인에 값을 입력해야 한다.
            //  team.addMember(member1);나 member1.changeTeam(team); 둘 중하나만 하면 됨
//            member1.changeTeam(team);
            em.persist(member1);
            
            team.addMember(member1);

            
            // 양쪽 다 값을 입력하지 않았을 경우
            team.getMember1s().add(member1);

            // 영속성 컨텍스트를 비워주지 않았을 경우
//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId());  // 1차 캐시에만 저장되어 있는 상태기 때문에
            List<Member1> member1s = findTeam.getMember1s();// 컬렉션을 불러와도 값이 없어서

            for(Member1 m : member1s){
                System.out.println("m = " + m.getUsername());// 출력되지 않는다
            }

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
