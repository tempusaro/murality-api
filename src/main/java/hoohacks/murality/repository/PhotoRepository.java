package hoohacks.murality.repository;

import hoohacks.murality.entity.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {

    Photo findPhotoByPid(@Param("pid")  long pid);

    Photo deletePhotoByPid(@Param("pid")  long pid);
}
