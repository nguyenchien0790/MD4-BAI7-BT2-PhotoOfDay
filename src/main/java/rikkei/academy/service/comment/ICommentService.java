package rikkei.academy.service.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.model.Comment;
import rikkei.academy.service.IGenericService;

import java.util.Date;

public interface ICommentService extends IGenericService<Comment> {
    Page<Comment> findAllByDate(Date date, Pageable pageable);
}
