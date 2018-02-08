package smth.service;


import smth.domain.Point;

import java.util.List;

public interface PointService {
    List<Point> listAll();

    List<Point> getByUserId(Long userId);

    Point saveOrUpdate(Point point);

    void delete(Long userId);

    void save(Point point);
}
