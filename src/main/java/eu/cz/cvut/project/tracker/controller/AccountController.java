package eu.cz.cvut.project.tracker.controller;

import eu.cz.cvut.project.tracker.model.Account;
import eu.cz.cvut.project.tracker.model.User;
import eu.cz.cvut.project.tracker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account")
    public String showAccount(@AuthenticationPrincipal User user,
                              Model model){
        model.addAttribute("accounts", accountRepository.findAllByAuthor(user));
        return "account";
    }

    @PostMapping("/account")
    public String addAccount(@AuthenticationPrincipal User user,
                             @RequestParam String title, Model model)
    {
        Account account = new Account(title, user);

        accountRepository.save(account);
        model.addAttribute("accounts", accountRepository.findAllByAuthor(user));
        return "account";  //redirect debtors in future
    }
}
