package onetToMany;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Team {


    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

/*
    일대다 주인=member
    @OneToMany(mappedBy = "team")   // team에 의해서 매핑이 된다
    private List<Member1> member1s = new ArrayList<Member1>();*/


    // 일대다 단방향에서는 JoinColumn을 꼭 사용해야 한다 . 그렇지 않으면 조인테이블 방식을 사용한다.
    // 일대다 주인=team
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member1> members1 = new ArrayList<Member1>();


}
