package com.example.casemd4mxh.controller;

import com.example.casemd4mxh.model.Comment;
import com.example.casemd4mxh.model.account.User;
import com.example.casemd4mxh.service.CommentService;
import com.example.casemd4mxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("comments")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<Iterable<Comment>> showAllComment() {
        List<Comment> commentList = (List<Comment>) commentService.findAll();
        if (commentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Comment>> showAllCommentByImageId(@PathVariable Long id) {
        List<Comment> commentListByImageId = (List<Comment>) commentService.findAllByImageId(id);
        if (commentListByImageId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commentListByImageId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Iterable<Comment>> addComment(@RequestBody Comment comment){
        comment.setTime(LocalDateTime.now());
        User user = userService.findById(comment.getUser().getId()).get();
        comment.setUser(user);
        commentService.save(comment);
        List<Comment> commentListByImageId = (List<Comment>) commentService.findAllByImageId(comment.getImage().getId());
        if (commentListByImageId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(commentListByImageId, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> editComment(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setId(id);
        comment.setTime(LocalDateTime.now());
        commentService.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {
        Optional<Comment> commentOptional = commentService.findById(id);
        if (!commentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
