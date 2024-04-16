package vsg.veera.bloggingapp_springboot.services;

import org.springframework.stereotype.Service;
import vsg.veera.bloggingapp_springboot.repositories.CommentRepository;

@Service
public class CommentsService {

    private CommentRepository commentRepository;

    public CommentsService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
