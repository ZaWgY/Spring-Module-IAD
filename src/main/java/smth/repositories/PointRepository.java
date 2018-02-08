package smth.repositories;

import org.springframework.data.repository.CrudRepository;
import smth.domain.Point;


public interface PointRepository extends CrudRepository<Point,Long> {

}
