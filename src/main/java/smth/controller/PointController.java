package smth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smth.domain.Point;
import smth.service.PointService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PointController {
    private PointService pointService;


    @Autowired
    public void setProductService(PointService pointService) {
        this.pointService = pointService;
    }

    @RequestMapping("/")
    public List<Point> mainMethod(){
        return pointService.listAll();
    }

    @RequestMapping("/save")
    public void savePoint(){
        pointService.save(new Point(1.0F , 2.0F , 3.0F ,true ,2L));
    }
    @RequestMapping("/userPoint")
    public List<Point> getUserPoints(){
        return null;
    }

}
