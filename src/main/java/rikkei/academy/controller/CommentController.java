package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rikkei.academy.model.Comment;
import rikkei.academy.service.comment.ICommentService;

import java.util.Date;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/")
    public String index(Model model,@PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.findAllByDate(new Date(), pageable));
        return "/index";
    }

    @PostMapping("/comment")
    public String comment(Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

    @PostMapping("/like")
    public String like(@RequestParam("id") Optional<Comment> comment) {
        if (!comment.isPresent()) {
            return "/error.404";
        }

        Comment comment1 = comment.get();
        comment1.setLikeCount(comment1.getLikeCount() + 1);
        commentService.save(comment1);
        return "redirect:/";
    }
}
