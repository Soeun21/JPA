package oneToOne;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member2 {


    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;


    @Column(name = "USERNAME")
    private String username;


    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;






}
