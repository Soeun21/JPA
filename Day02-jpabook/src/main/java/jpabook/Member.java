package jpabook;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Data
public class Member {

    @Id @GeneratedValue //생략하면 Auto전략
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(length = 10)
    private String name;

    private String city;

    private String street;

    private String zipcode;

}
