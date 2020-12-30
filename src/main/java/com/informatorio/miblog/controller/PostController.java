package com.informatorio.miblog.controller;

import com.informatorio.miblog.models.Post;
import com.informatorio.miblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/hello")
    public String Hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s", name);
    }

    //GET todos los post
    @GetMapping
    public ResponseEntity<?> getPost(){

        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    //POST  Crear un post
    @PostMapping("/add")
    public ResponseEntity<?> createPost(@RequestBody Post post){

            return  new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("edit/{postid}")
    public ResponseEntity<?> EditarPost(@PathVariable Long postid, @RequestBody Post post){
        Post postEdit = (Post)postRepository.getOne(postid);

        postEdit.setTitle(post.getTitle());
        postEdit.setDescription(post.getDescription());
        postEdit.setContent(post.getContent());
        postEdit.setPublished(post.getPublished());



        return new ResponseEntity<>(postRepository.save(postEdit), HttpStatus.OK);
    }

    @DeleteMapping("delete/{postId}")
    public List<String> borrarPost(@PathVariable Long postId) {

        postRepository.deleteById(postId);
        List<String> retornar = new ArrayList<>();
        retornar.add("Borrado correctamente");
        return retornar;
    }


    }




