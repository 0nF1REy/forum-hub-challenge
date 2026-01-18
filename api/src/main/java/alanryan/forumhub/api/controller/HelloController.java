package alanryan.forumhub.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Tag(name = "1. Hello")
public class HelloController {

    @GetMapping
    public String olaMundo() {
        return "Hello World! API FórumHub conectada e rodando.";
    }
}
