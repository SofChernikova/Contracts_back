package chernikova.s.a.TDD.services;

import org.springframework.stereotype.Service;

@Service
public class CheckService {
    //имитация сервиса, который взаимодействует со сторонними сервисами и проверяет, валидна ли компания/сотрудник компании

    public boolean checkCompany(String companyName, String INN, String OGRN) {
        return true;
    }
    public boolean checkStaff(String companyName, String surname, String name, String lastname) {
        return true;
    }
}
