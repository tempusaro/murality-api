package hoohacks.murality.repository;

import hoohacks.murality.entity.Canvas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanvasRepository extends CrudRepository<Canvas, Long> {

}
