package eu.cz.cvut.project.tracker.controller;

import eu.cz.cvut.project.tracker.model.Account;
import eu.cz.cvut.project.tracker.model.User;
import eu.cz.cvut.project.tracker.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
                             @RequestParam String title, String text, Model model)
    {
        Account account = new Account(title, text, user);

        accountRepository.save(account);
        model.addAttribute("accounts", accountRepository.findAllByAuthor(user));
        return "account";  //redirect debtors in future
    }

    @GetMapping("/account/delete")
    public String deleteAccount(@AuthenticationPrincipal User user,
                                @RequestParam Long id, Model model){
        Account account = accountRepository.findAccountById(id);
        accountRepository.delete(account);
        model.addAttribute("accounts", accountRepository.findAllByAuthor(user));
        return "redirect:/account";
    }
    @GetMapping("/account/update")
    public String updateAccountShow( @RequestParam Long id, Model model){
        //Account account = accountRepository.findAccountById(id);
        model.addAttribute("account", accountRepository.findAccountById(id));
        return "updateAcc";
    }
    @PostMapping("/account/update")
    public String updateAccount(@RequestParam Long id, String title, String text, Model model){
        if(text != null || title != null) {
            Account account = accountRepository.findAccountById(id);
            if(text != null){
                account.setText(text);
            }
            if(title != null) {
                account.setTitle(title);
            }
            accountRepository.save(account);
        }
        return "redirect:/account";
    }

}
