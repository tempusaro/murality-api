package hoohacks.murality.entity;

import lombok.Data;

@Data
public class Photo {
    long pid;

    String fileLink;

    User uploader;

    // position (x, y)
    String x;

    String y;

    // size
    String width;

    String height;
}
