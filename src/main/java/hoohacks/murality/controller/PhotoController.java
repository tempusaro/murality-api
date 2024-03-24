package hoohacks.murality.controller;
import hoohacks.murality.entity.Photo;
import hoohacks.murality.service.PhotoService;
import hoohacks.murality.service.StorageService;

import hoohacks.murality.module.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    private StorageService service;

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    }

    @GetMapping("/download/{pid}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String pid) {
        byte[] data = service.downloadFile(pid);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + pid + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteFile(@PathVariable String pid) {
        return new ResponseEntity<>(service.deleteFile(pid), HttpStatus.OK);
    }

    @GetMapping("/get/{pid}")
    public ResponseEntity getPhoto(@PathVariable String pid) {
        Long photoId = Long.parseLong(pid);

        Photo photo = photoService.getPhoto(photoId);
        if (photo == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(photo, HttpStatus.OK);
    }
}
