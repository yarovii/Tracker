/*
package eu.cz.cvut.project.tracker.controller;

import eu.cz.cvut.project.tracker.model.User;
import eu.cz.cvut.project.tracker.repository.DebtorRepository;
import eu.cz.cvut.project.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/debtors")
public class DebtController {
    @Autowired
    private DebtorRepository debtorRepository;

    @Autowired
    private UserRepository userRepository;

    public String debtorsList(Model model){
        model.addAttribute("debtors", debtorRepository.findAll());
        return "debtors";
    }

    @PostMapping("/addDebtorWithDebt")
    public String addDebtorWithDebt(@RequestParam float price,
                                    @RequestParam String username,
                                    String text,
                                    Model model,
                                    User user){
        debtorRepository.

    }
}
*/
