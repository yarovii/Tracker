package eu.cz.cvut.project.tracker.repository;

import eu.cz.cvut.project.tracker.model.Account;
import eu.cz.cvut.project.tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByAuthor(User author);

}
