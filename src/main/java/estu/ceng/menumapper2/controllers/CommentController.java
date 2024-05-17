package estu.ceng.menumapper2.controllers;

import estu.ceng.menumapper2.dtos.CommentDTO;
import estu.ceng.menumapper2.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {this.commentService = commentService;}

    @GetMapping("get/comments")
    public List<CommentDTO> getComments() {
        return commentService.findAll();
    }

    @GetMapping("get/averageStars/{cafeId}")
    public double getAverageStars(@PathVariable String cafeId) {
        return commentService.GetAverageCafeStars(cafeId);
    }

    @GetMapping("get/commentsWithCafeId/{cafeId}")
    public List<CommentDTO> getCommentsWithCafeId(@PathVariable String cafeId) {
        return commentService.findAllCafeComments(cafeId);
    }

    @PostMapping("add/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDTO postComment(@RequestBody CommentDTO CommentDTO) {
        return commentService.save(CommentDTO);
    }

    @DeleteMapping("delete/comment/{commentId}")
    public Long deleteComment(@PathVariable String commentId) {
        return commentService.delete(commentId);
    }

    @PutMapping("/update/comment")
    public CommentDTO updateComment(@RequestBody CommentDTO CommentDTO) {
        return commentService.update(CommentDTO);
    }




}
