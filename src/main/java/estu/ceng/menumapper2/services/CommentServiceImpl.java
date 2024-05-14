package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.CommentDTO;
import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository){this.commentRepository = commentRepository;}

    @Override
    public long delete(String commentId) {
        return commentRepository.delete(commentId);
    }

    @Override
    public CommentDTO update(CommentDTO CommentDTO) {
        return new CommentDTO(commentRepository.update(CommentDTO.toCommentEntity()));
    }

    @Override
    public List<CommentDTO> findAll() {
        return commentRepository.findAll().stream().map(CommentDTO::new).toList();
    }

    @Override
    public List<CommentDTO> findAllCafeComments(String cafeId) {
        return commentRepository.findAllCafeComments(cafeId).stream().map(CommentDTO::new).toList();
    }

    @Override
    public CommentDTO save(CommentDTO CommentDTO) {
        return new CommentDTO(commentRepository.save(CommentDTO.toCommentEntity()));
    }

    @Override
    public double GetAverageCafeStars(String cafeId) {
        return commentRepository.GetAverageCafeStars(cafeId);
    }
}
