package smth.service;


import smth.domain.Point;

import java.util.List;

public interface PointService {
    List<Point> listAll();

    List<Point> getByUserId(String userId);

    Point saveOrUpdate(Point point);

    void delete(String name);

    void save(Point point);

    void clearAll();
}
