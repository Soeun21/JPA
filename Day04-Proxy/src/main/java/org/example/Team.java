package org.example;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Team {


    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;




}
