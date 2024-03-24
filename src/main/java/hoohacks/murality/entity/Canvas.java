package hoohacks.murality.entity;

import lombok.Data;

import java.util.List;

@Data
public class Canvas {

    long cid;

    // userId by photo creater
    String uid;

    List<Photo> pictures;
}
