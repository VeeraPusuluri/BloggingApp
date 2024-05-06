package vsg.veera.bloggingapp_springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticlesController {


    @GetMapping()
    String getArticles(){
        return "Articles";
    }
}
