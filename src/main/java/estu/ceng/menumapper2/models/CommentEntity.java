package estu.ceng.menumapper2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class CommentEntity {
    private ObjectId id;
    private int score;
    private String commentMessage;
    private String userId;
    private String cafeId;
}
