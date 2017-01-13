package com.example.Controllers;

import com.example.Models.Post;
import com.example.Models.Posts;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Nick on 1/12/17.
 */
@Controller
public class FileUploadController extends BaseController {

    @Autowired
    Posts postsDao;

    @Value("${file-upload-path}")
    private String uploadPath;

    @GetMapping("/fileupload/{id}")
    public String showUploadFileForm(@PathVariable long id, Model model) {
        Post post = postsDao.findOne(id);

        if (post.getUser().getId() != loggedInUser().getId()){
            return "posts/index";
        }
        model.addAttribute("post", post);
        return "posts/fileupload";


    }

    @PostMapping("/fileupload/{id}")
    public String saveFile(
            @RequestParam(name = "file") MultipartFile uploadedFile, Post post,
            Model model
    ) {
        Post newPost = postsDao.findOne(post.getId());
        newPost.setUpload_path(post.getUpload_path());
        postsDao.save(newPost);

        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);

        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");




        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        return "redirect:/posts";
    }
}
