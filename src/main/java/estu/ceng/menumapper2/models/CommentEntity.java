package estu.ceng.menumapper2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
    private ObjectId id;
    private int score;
    private String commentMessage;
    private String userId;
    private String cafeId;
}
