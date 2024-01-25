package chernikova.s.a.TDD.controllers;

import chernikova.s.a.TDD.models.Contract;
import chernikova.s.a.TDD.models.forms.ContractForm;
import chernikova.s.a.TDD.services.ContractService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contracts")
@CrossOrigin("http://localhost:5173")
public class ContractController {

    private final ContractService contractService;

    @PostMapping("/{id}/create")
    public Contract create(@Valid @RequestBody ContractForm form, @PathVariable Long id){
        return contractService.create(form, id);
    }

    @GetMapping("/{id}/{num}")
    public Contract getById(@PathVariable String num, @PathVariable Long id){
        return contractService.getById(num);
    }

    @PostMapping("/{id}/{num}")
    public Contract edit(@Valid @RequestBody ContractForm form, @PathVariable String num, @PathVariable Long id){
        return contractService.edit(num, form);
    }

    @GetMapping("/{id}")
    public List<Contract> getAll(@PathVariable Long id){
        return contractService.getAll(id);
    }

    @DeleteMapping("/{id}/{num}")
    public void delete(@PathVariable String num, @PathVariable Long id){
        contractService.delete(num);
    }
}
