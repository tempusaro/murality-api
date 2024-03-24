package hoohacks.murality.controller;

import hoohacks.murality.module.Response;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("me/{username}")
    public Response getUserProfile(@PathVariable String username) {

        // getId by username


        // return Response<>(user)
        return new Response();
    }

    @PutMapping("me/{username}")
    public Response updateUserProfile(@PathVariable String username) {
        // getId by username
        // User user = userReposity.getById(request.id)

        // assign value
        // user.picture = request.profilePicture;
        // ...

        // db.update(user);

        // return Response<>(success, user);
        return new Response();
    }
}
