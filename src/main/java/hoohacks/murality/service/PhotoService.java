package hoohacks.murality.service;

import hoohacks.murality.entity.User;
import hoohacks.murality.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;


    public User getPhoto(int pid) {

        return null;
    }



    public User deletePhoto(int pid) {

        return null;
    }

}
