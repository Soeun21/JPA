package org.example;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue //생략하면 Auto전략
    private Long id;
    private String name;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child){// 양방향 연관관계 걸기
        childList.add(child);
        child.setParent(this);
    }

}
