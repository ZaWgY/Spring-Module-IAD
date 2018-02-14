package smth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void savePoint(){
        pointService.save(new Point(1.0F , 2.0F , 3.0F ,true ,"Proverka"));
    }

    @RequestMapping(value = "/userPoint/{name}", method = RequestMethod.GET)
    public List<Point> getUserPoints(@PathVariable String name){
        System.out.println("Имя пришедшее с гет запроса " + name);
        List<Point> points= pointService.getByUserId(name);
        return points;
    }

    @RequestMapping(value = "/addPoint", method = RequestMethod.POST)
    public ResponseEntity addPoint(@RequestBody Point point ){
        System.out.println(point);
        pointService.save(new Point(point.getX(),point.getY(),point.getR(),point.checkHit(),point.getUserId()));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "clearPoints", method = RequestMethod.GET)
    public void clearPoint(){
        pointService.clearAll();
    }

    @RequestMapping(value = "clearPersonPoints/{name}", method = RequestMethod.GET)
    public void clearPersonPoints(@PathVariable String name){
        System.out.println("Удалить точки юзера "+name);
        pointService.delete(name);
    }

}
