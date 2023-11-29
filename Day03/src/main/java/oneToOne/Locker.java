package oneToOne;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Locker {


    @Id @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")  // 읽기 전용으로 매핑
    private Member2 member2;
}
