package vsg.veera.bloggingapp_springboot.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article/{article-slug}/comments")
public class CommentsController {

    @GetMapping("")
   public String getComments(){
        return "comments";
    }
}
