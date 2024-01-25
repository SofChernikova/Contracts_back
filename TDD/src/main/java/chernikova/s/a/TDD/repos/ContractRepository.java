package chernikova.s.a.TDD.repos;

import chernikova.s.a.TDD.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    Optional<Contract> findContractByNum(String num);

    List<Contract> findAllByUserId(Long id);

}
