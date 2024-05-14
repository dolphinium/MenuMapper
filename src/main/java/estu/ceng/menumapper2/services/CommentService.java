package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {
    long delete(String commentId);
    CommentDTO update(CommentDTO CommentDTO);
    List<CommentDTO> findAll();
    List<CommentDTO> findAllCafeComments(String cafeId);
    CommentDTO save(CommentDTO CommentDTO);
    double GetAverageCafeStars(String cafeId);
}
