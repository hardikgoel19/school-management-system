package studentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
