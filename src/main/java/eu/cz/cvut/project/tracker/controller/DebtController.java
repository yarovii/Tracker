package eu.cz.cvut.project.tracker.controller;

import eu.cz.cvut.project.tracker.model.Debt;
import eu.cz.cvut.project.tracker.model.User;
import eu.cz.cvut.project.tracker.repository.AccountRepository;
import eu.cz.cvut.project.tracker.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/account/{id}/delete")
    public String deleteDebt(@PathVariable("id") Long acc_id,
                             @RequestParam Long id, Model model){
        Debt debt = debtRepository.findDebtById(id);
        debtRepository.delete(debt);
        model.addAttribute("debts", debtRepository.findAllByAccount_Id(id));
        model.addAttribute("account", acc_id);
        return "redirect:/account/"+acc_id;
    }

    @PostMapping("/account/{id}/update")
    public String updateDebt(@PathVariable("id") Long acc_id,
                             @RequestParam("debt_id") Long debt_id,
                             float price, String comment,
                             Model model){
        Debt debt = debtRepository.findDebtById(debt_id);

        debt.setPrice(price);
        debt.setComment(comment);
        debtRepository.save(debt);

        model.addAttribute("debts", debtRepository.findAllByAccount_Id(debt_id));
        model.addAttribute("account", acc_id);

        return "redirect:/account/"+acc_id;
    }
    @GetMapping("/account/{id}/update")
    public String updateDebtShow(@PathVariable("id") Long acc_id,
                                 @RequestParam Long id,
                                 Model model){
        model.addAttribute("debt", debtRepository.findDebtById(id));
        model.addAttribute("account", acc_id);

        return "updateDebt";
    }

}
