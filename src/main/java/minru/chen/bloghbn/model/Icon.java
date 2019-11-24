package minru.chen.bloghbn.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_icon")
public class Icon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iconID;
    private Long userID;
    private String filename;

}
