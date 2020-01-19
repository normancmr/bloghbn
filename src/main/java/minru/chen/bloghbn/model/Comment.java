package minru.chen.bloghbn.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private Long blog_id;
    private Long user_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

}
