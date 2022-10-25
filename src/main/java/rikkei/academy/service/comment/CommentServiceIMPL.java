package rikkei.academy.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.model.Comment;
import rikkei.academy.repository.ICommentRepository;

import java.util.Date;
import java.util.Optional;

public class CommentServiceIMPL implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Comment> findAllByDate(Date date, Pageable pageable) {
        return commentRepository.findAllByDate(date, pageable);
    }
}
