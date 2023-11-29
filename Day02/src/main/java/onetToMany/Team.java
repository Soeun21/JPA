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

    @OneToMany(mappedBy = "team")
    private List<Member1> member1s = new ArrayList<Member1>();


    public void addMember(Member1 member1) {
        member1.setTeam(this);
        member1s.add(member1);
    }
}
