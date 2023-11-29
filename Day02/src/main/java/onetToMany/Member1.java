package onetToMany;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member1 {


    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;


    @Column(name = "USERNAME")
    private String username;


//    외래키가 있는 곳이 주인이 된다
    //객체를 테이블에 맞추어 모델링
  /*  @Column(name = "TEAM_ID")
    private Long teamId;*/
    //단방향 연관관계 / 양방향 연관관계 모두 동일
    @ManyToOne(fetch = FetchType.LAZY)// (fetch = FetchType.LAZY): 지연로딩 전략
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    public void changeTeam(Team team) {
        this.team = team;
        team.getMember1s().add(this);
    }



}
