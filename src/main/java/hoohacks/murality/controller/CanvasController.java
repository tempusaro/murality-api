package hoohacks.murality.controller;

import hoohacks.murality.entity.Canvas;
import hoohacks.murality.service.CanvasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/canvas/")
@RequiredArgsConstructor
public class CanvasController {

    @Autowired
    CanvasService canvasService;

    @GetMapping("get/{username}")
    public ResponseEntity getCanvas(@PathVariable String username) {
        Canvas canvas = canvasService.getCanvas(username);

        return new ResponseEntity(canvas, HttpStatus.OK);
    }
}
