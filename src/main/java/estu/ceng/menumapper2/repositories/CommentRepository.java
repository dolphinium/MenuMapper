package estu.ceng.menumapper2.repositories;

import estu.ceng.menumapper2.dtos.CommentDTO;
import estu.ceng.menumapper2.models.CommentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository {
    long delete(String commentId);
    CommentEntity update(CommentEntity CommentEntity);
    List<CommentEntity> findAll();
    List<CommentEntity> findAllCafeComments(String cafeId);
    CommentEntity save(CommentEntity CommentEntity);
    double GetAverageCafeStars(String cafeId);
}
