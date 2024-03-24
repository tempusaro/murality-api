package hoohacks.murality.entity;

import lombok.Data;

@Data
public class User {

    long uid;

    String username;

    String password;

    String profilePicture;
}