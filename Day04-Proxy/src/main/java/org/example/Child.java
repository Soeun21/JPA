package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Child {
    @Id
    @GeneratedValue //생략하면 Auto전략
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="PARENT_IDs")
    private Parent parent;
}
