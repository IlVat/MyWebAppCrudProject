package iva.cruddwebapp.controller;

import iva.cruddwebapp.model.User;
import iva.cruddwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 01.04.15.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("add-user-form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute User user, BindingResult result) {

        ModelAndView modelAndView;

        if (result.hasErrors()) {
            modelAndView = new ModelAndView("add-user-form", result.getModel());
        } else {
            modelAndView = new ModelAndView("home");
            userService.addUser(user);
            String message = "User was successfully added.";
            modelAndView.addObject("message", message);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        User user = userService.getUser(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView editingUser(@Valid @ModelAttribute User user, BindingResult result, @PathVariable Integer id) {

        ModelAndView modelAndView;

        if (result.hasErrors()) {
            modelAndView = new ModelAndView("edit-user-form", result.getModel());
        } else {
            modelAndView = new ModelAndView("home");
            userService.updateUser(user);
            String message = "User was successfully edited.";
            modelAndView.addObject("message", message);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        userService.deleteUser(id);

        String message = "User was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listOfUsers(@RequestParam(value = "page", required = false) Integer page) {

        ModelAndView modelAndView = new ModelAndView("list-of-users");
        if (page == null) {
            page = 0;
        }

        int amountOfPages = (int) Math.ceil(userService.getAllUsers().size() * 1.0 / 10);
        List<User> users = userService.getUsers(page);

        modelAndView.addObject("users", users);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("amountOfPages", amountOfPages);

        return modelAndView;

    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchUser(@RequestParam(value = "page", required = false) Integer page,
                                   @ModelAttribute User user, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView("search-list");

        String userName = user.getName();
        String pattern = "%" + userName + "%";

        if (page == null) {
            page = 0;
        }

        int amountOfPages = (int) Math.ceil(userService.getAllUsersAfterSearch(pattern).size() * 1.0 / 10);
        List<User> users = userService.searchByName(pattern, page);

        modelAndView.addObject("users", users);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("amountOfPages", amountOfPages);

        return modelAndView;
    }
}