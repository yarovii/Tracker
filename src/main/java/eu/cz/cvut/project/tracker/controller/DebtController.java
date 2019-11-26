package eu.cz.cvut.project.tracker.controller;

import eu.cz.cvut.project.tracker.model.Debt;
import eu.cz.cvut.project.tracker.model.User;
import eu.cz.cvut.project.tracker.repository.AccountRepository;
import eu.cz.cvut.project.tracker.repository.DebtRepository;
import eu.cz.cvut.project.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DebtController {
    @Autowired
    private DebtRepository debtRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account/{id}")
    public String debtorsList(@PathVariable Long id,
                              Model model){
        model.addAttribute("debts", debtRepository.findAllByAccount_Id(id));
        model.addAttribute("account", id);
        return "allDebts";
    }
    @PostMapping("/account/{id}")
    public String debtorsAdd(@PathVariable Long id,
                              @RequestParam float price,
                              @RequestParam String comment,
                              boolean active,
                              Model model)
    {
        Debt debt = new Debt(price, comment, accountRepository.findAccountById(id), active);

        debtRepository.save(debt);
        model.addAttribute("debts", debtRepository.findAllByAccount_Id(id));
        model.addAttribute("account", id);
        return "allDebts";
    }

}
