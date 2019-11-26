package eu.cz.cvut.project.tracker.repository;

import eu.cz.cvut.project.tracker.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebtRepository extends JpaRepository<Debt, Long> {
    List<Debt> findAllByAccount_Id(Long id);
}
