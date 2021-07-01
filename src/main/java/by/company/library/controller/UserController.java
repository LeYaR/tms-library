package by.company.library.controller;

import by.company.library.domain.dto.UserDto;
import by.company.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @PostMapping("home_page")
    public String greetingSubmit(@ModelAttribute UserDto userDto, Model model) {
        model.addAttribute("passportNo", userDto.getPassportNo());
        model.addAttribute("password", userDto.getPassword());
        return "redirect:/books/list";
    }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("users", userDto);
        return "create_account";
    }

    @PostMapping("/save")
    public String saveUsers(@ModelAttribute("users") UserDto userDto){
        // save the user
        service.saveUser(userDto);
        return "redirect:/users/login";
    }
}
