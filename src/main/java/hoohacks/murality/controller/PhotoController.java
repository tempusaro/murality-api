package hoohacks.murality.controller;

import hoohacks.murality.module.Response;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {


    @PutMapping("upload")
    public Response uploadPicture() {

        return new Response();
    }
}
