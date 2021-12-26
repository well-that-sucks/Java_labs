package controller.command;

import model.User;
import service.UserService;
import utils.Validations;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Registration implements Command {

    private final UserService userService;

    public Registration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            return "WEB-INF/registration.jsp";
        }

        try {
            Optional<User> foundUser = userService.findByUserName(request.getParameter("userName"));
            if (foundUser.isEmpty()) {
                User user = new User();
                user.setName(request.getParameter("name"));
                user.setLastName(request.getParameter("lastName"));
                user.setUserName(request.getParameter("userName"));
                user.setEmail(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));

                userService.createUser(user);
                request.removeAttribute("userAlreadyExists");

            } else if (foundUser.isPresent()) {
                request.setAttribute("userAlreadyExists", "User with such username already exists");
                return "WEB-INF/registration.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/registration";
        }
        return "redirect:/login";
    }
}