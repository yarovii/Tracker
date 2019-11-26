package eu.cz.cvut.project.tracker.repository;

import eu.cz.cvut.project.tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
