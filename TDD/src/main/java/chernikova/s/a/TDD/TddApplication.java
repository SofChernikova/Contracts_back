package chernikova.s.a.TDD;

import chernikova.s.a.TDD.models.Contract;
import chernikova.s.a.TDD.repos.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TddApplication implements CommandLineRunner {

	@Autowired
	private ContractRepository contractRepository;
	public static void main(String[] args)  {
		SpringApplication.run(TddApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contract contract1 = Contract.builder()
				.name("Contract 1")
				.num("202312345")
				.defendant("Me")
				.initiator("Him")
				.description("Contract 1")
				.conclusionDate(LocalDate.EPOCH)
				.expirationDate(LocalDate.MAX)
				.build();
		Contract contract2 = Contract.builder()
				.name("Contract 1")
				.num("202312346")
				.defendant("Me")
				.initiator("Him")
				.description("Contract 1")
				.conclusionDate(LocalDate.EPOCH)
				.expirationDate(LocalDate.MAX)
				.build();
		Contract contract3 = Contract.builder()
				.name("Contract 1")
				.num("202312347")
				.defendant("Me")
				.initiator("Him")
				.description("Contract 1")
				.conclusionDate(LocalDate.EPOCH)
				.expirationDate(LocalDate.MAX)
				.build();
		this.contractRepository.save(contract1);
		this.contractRepository.save(contract2);
		this.contractRepository.save(contract3);
	}
}
