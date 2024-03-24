package hoohacks.murality.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import hoohacks.murality.entity.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {

    long pid;

    @JsonProperty("fileLink")
    String fileLink;

    // User Who Uploader
    @JsonProperty("uid")
    long uid;

    @JsonProperty("cid")
    long cid;

    // position (x, y)
    @JsonProperty("x")
    String x;

    @JsonProperty("y")
    String y;

    // size
    @JsonProperty("width")
    String width;

    @JsonProperty("height")
    String height;

    public Photo toPhoto() {
        // Assuming the Photo entity has a matching constructor
        // Photo photo = new Photo(pid, fileLink, uid, x, y, width, height);
        // return photo;

        // Or, if the Photo entity has setters instead of a matching constructor
        Photo photo = new Photo();
        photo.setPid(pid);
        photo.setFileLink(fileLink);
        photo.setCid(cid);
        photo.setUid(uid);
        photo.setX(x);
        photo.setY(y);
        photo.setWidth(width);
        photo.setHeight(height);
        return photo;
    }
}
