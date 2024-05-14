package estu.ceng.menumapper2.dtos;

import estu.ceng.menumapper2.models.CommentEntity;
import org.bson.types.ObjectId;

public record CommentDTO(
        String id,
        int score,
        String commentMessage,
        String userId,
        String cafeId
) {
    public CommentDTO(CommentEntity p){
        this(p.getId() == null ? new ObjectId().toHexString():p.getId().toHexString(),
                p.getScore(),
                p.getCommentMessage(),
                p.getUserId(),
                p.getCafeId());
    }

    public CommentEntity toCommentEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new CommentEntity(_id,score,commentMessage,userId,cafeId);
    }
}
