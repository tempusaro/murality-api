package hoohacks.murality.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hoohacks.murality.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
