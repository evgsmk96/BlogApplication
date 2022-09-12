package com.example.blogapplication.controllers;

import com.example.blogapplication.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.blogapplication.repo.PostRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepo;

    @GetMapping("/blog")
    public String blogMain (Model model) {
        Iterable<Posts> posts = postRepo.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogAddPost (@RequestParam String title, @RequestParam String anons, @RequestParam String full_text,Model model) {
        Posts posts = new Posts(title, anons, full_text);
        postRepo.save(posts);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value="id") long id, Model model) {
        if(!postRepo.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Posts> post = postRepo.findById(id);
        ArrayList<Posts> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-details";

    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value="id") long id, Model model) {
        if(!postRepo.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Posts> post = postRepo.findById(id);
        ArrayList<Posts> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-edit";

    }

    @PostMapping("/blog/{id}/edit")
    public String blogUpdate(@PathVariable(value="id") long id,@RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model) {
        Posts post = postRepo.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepo.save(post);
        return "redirect:/blog";

    }


}
