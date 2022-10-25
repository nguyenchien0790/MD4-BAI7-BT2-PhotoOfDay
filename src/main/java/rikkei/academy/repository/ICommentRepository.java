package rikkei.academy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import rikkei.academy.model.Comment;

import java.util.Date;

public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findAllByDate(Date date, Pageable pageable);
}
