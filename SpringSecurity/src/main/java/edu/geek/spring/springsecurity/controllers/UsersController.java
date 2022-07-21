package edu.geek.spring.springsecurity.controllers;

import edu.geek.spring.springsecurity.entities.User;
import edu.geek.spring.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    //добавление нового пользователя
    @PostMapping("/users/create")
    public String createUser(User user) {
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    //получение всех пользователей
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "users";
    }

    //Страница изменения пользователя
    @GetMapping("/users/change/{id}")
    public String getUserChangePage(Model model,
                                @PathVariable(value = "id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "userchange";
    }

    //Изменение пользователя
    @PostMapping("/users/change")
    public String changeUser(User user) {
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    //удаление пользователя
    @GetMapping("/users/delete/{id}")
    public String deleteUser(Model model,
                             @PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
