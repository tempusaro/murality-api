package hoohacks.murality.controller;

import hoohacks.murality.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    private StorageService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestBody byte[] fileBytes) {
        try {
            // Assuming your service can handle a byte array directly
            String fileName = service.uploadFile(fileBytes);

            if (fileName == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to upload the file.");
            }

            return ResponseEntity.ok(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while uploading the file.");
        }
    }

    @GetMapping("/download/{pid}")
    public ResponseEntity<?> downloadFile(@PathVariable String pid) {
        try {
            byte[] data = service.downloadFile(pid);
            ByteArrayResource resource = new ByteArrayResource(data);
            return ResponseEntity
                    .ok()
                    .contentLength(data.length)
                    .header("Content-type", "application/octet-stream")
                    .header("Content-disposition", "attachment; filename=\"" + pid + "\"")
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteFile(@PathVariable String pid) {
        if (!service.deleteFile(pid)) {
            return new ResponseEntity<>("File not found: " + pid, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
