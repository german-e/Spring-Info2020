package com.informatorio.miblog.controller;

import com.informatorio.miblog.models.Comment;
import com.informatorio.miblog.models.Post;
import com.informatorio.miblog.repository.CommentRepository;
import com.informatorio.miblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


       //GET todos los post
    @GetMapping
    public ResponseEntity<?> getComments(){

        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }

    //POST  Crear un post
    @PostMapping("/add")
    public ResponseEntity<?> createComment(@RequestBody Comment post){

        return  new ResponseEntity<>(commentRepository.save(post), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("edit/{commentid}")
    public ResponseEntity<?> EditarPost(@PathVariable Long commentid, @RequestBody Comment c){
        Comment commentForEdit = (Comment)commentRepository.getOne(commentid);

        commentForEdit.setComment(c.getComment());

        return new ResponseEntity<>(commentRepository.save(commentForEdit), HttpStatus.OK);
    }


    @DeleteMapping("delete/{commentId}")
    public List<String> borrarPost(@PathVariable Long commentId) {

        commentRepository.deleteById(commentId);
        List<String> retornar = new ArrayList<>();
        retornar.add("Borrado correctamente");
        return retornar;
    }


}




