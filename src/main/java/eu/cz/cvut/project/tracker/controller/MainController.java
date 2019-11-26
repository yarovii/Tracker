package eu.cz.cvut.project.tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /*@Autowired
    AccountRepository accountRepository;*/

    @GetMapping("/")
    public String main(){   //Returns main page
        return "main";
    }

    /*@GetMapping("/debtors")
    public String showAccounts(Model model){
        model.addAttribute("accounts", accountRepository.findAll());
        return "debtors";
    }

    @PostMapping("/debtors")
    public String addAccount(@AuthenticationPrincipal User user,
                             @RequestParam String accName)
    {
        Account account = new Account(accName, user);
        accountRepository.save(account);
        return "debtors";
    }*/
}
