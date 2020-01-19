package minru.chen.bloghbn.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_blog")
public class Blog implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long visited;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date upateTime;
    private String title;
    private String summary;
    private String filename;
    private Long type_id;
    private Long category_id;


    @Override
    public Blog clone() throws CloneNotSupportedException {
        return (Blog)super.clone();
    }
}
