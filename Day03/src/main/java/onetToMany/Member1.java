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


    // 연관관계 주인처럼 되기 때문에 insertable = false, updatable = false) 걸어주기
    // 읽기 전용 필드로 변경해서 최종적으로 insert를 하지 않게 한다
    @ManyToOne
    @JoinColumn(name="TEAM_ID",insertable = false, updatable = false)
    private Team team;



}
