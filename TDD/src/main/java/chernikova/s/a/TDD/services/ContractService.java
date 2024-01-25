package chernikova.s.a.TDD.services;

import chernikova.s.a.TDD.models.Contract;
import chernikova.s.a.TDD.models.forms.ContractForm;
import chernikova.s.a.TDD.repos.ContractRepository;
import chernikova.s.a.TDD.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final UserService userService;

    public Contract create(ContractForm form, Long id) {
        String[] conclusionDate = form.getConclusionDate().split("\\.");
        String[] expirationDate = form.getExpirationDate().split("\\.");

        LocalDate cDate = LocalDate.of(Integer.parseInt(conclusionDate[2]), Integer.parseInt(conclusionDate[1]),
                Integer.parseInt(conclusionDate[0]));
        LocalDate eDate = LocalDate.of(Integer.parseInt(expirationDate[2]), Integer.parseInt(expirationDate[1]),
                Integer.parseInt(expirationDate[0]));

       String num = "2020-" + ((int) (Math.random() * 10001) + "");
        System.out.println(num);

        Contract contract = Contract.builder()
                .name(form.getName())
                .num(num)
                .defendant(form.getDefendant())
                .initiator(form.getInitiator())
                .description(form.getDescription())
                .conclusionDate(cDate)
                .expirationDate(eDate)
                .user(userService.getUserById(id))
                .build();
        return contractRepository.save(contract);
    }

    public Contract edit(String num, ContractForm form){
        Contract contract = contractRepository.findContractByNum(num).orElseThrow(
                () -> new IllegalArgumentException("")
        );

        String[] conclusionDate = form.getConclusionDate().split("\\.");
        String[] expirationDate = form.getExpirationDate().split("\\.");

        LocalDate cDate = LocalDate.of(Integer.parseInt(conclusionDate[2]), Integer.parseInt(conclusionDate[1]),
                Integer.parseInt(conclusionDate[0]));
        LocalDate eDate = LocalDate.of(Integer.parseInt(expirationDate[2]), Integer.parseInt(expirationDate[1]),
                Integer.parseInt(expirationDate[0]));

        contract.setDefendant(form.getDefendant());
        contract.setInitiator(form.getInitiator());
        contract.setDescription(form.getDescription());
        contract.setConclusionDate(cDate);
        contract.setExpirationDate(eDate);

        return contractRepository.save(contract);
    }

    public List<Contract> getAll(Long id){
        List<Contract> contracts =  contractRepository.findAllByUserId(id);
        System.out.println("");
        return  contracts;
    }
    public Contract getById(String num){
        return contractRepository.findContractByNum(num).orElseThrow(
                () -> new IllegalArgumentException("")
        );
    }

    public void delete(String num){
        contractRepository.delete(contractRepository.findContractByNum(num).orElseThrow());
    }
}
