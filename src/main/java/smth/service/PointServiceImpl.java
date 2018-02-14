package smth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smth.domain.Point;
import smth.repositories.PointRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    private PointRepository pointRepository;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Override
    public List<Point> listAll() {
        List<Point> points = new ArrayList<>();
        pointRepository.findAll().forEach(points::add);
        return points;
    }



    @Override
    public List<Point> getByUserId(String userId) {
        List<Point> points = new ArrayList<>();
        pointRepository.findAll().forEach(points::add);
        List<Point> necessaryPoints = new ArrayList<>();
        for (Point point: points) {
            if(point.getUserId().equals(userId)){
                necessaryPoints.add(point);
            }
        }
        return necessaryPoints;
    }

    @Override
    public void save(Point point){
        pointRepository.save(point);
    }

    @Override
    public void clearAll() {
        pointRepository.deleteAll();
    }

    @Override
    public Point saveOrUpdate(Point point) {
        return null;
    }

    @Override
    public void delete(String name) {
        List<Point> points = new ArrayList<>();
        pointRepository.findAll().forEach(points::add);
        for (Point point: points) {
            if(point.getUserId().equals(name)){
                pointRepository.delete(point);
            }
        }


    }

}
