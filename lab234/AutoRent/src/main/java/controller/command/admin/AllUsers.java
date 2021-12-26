package controller.command.admin;

import controller.command.Command;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

public class AllUsers implements Command {
    private final UserService userService;

    public AllUsers(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("users",  userService.findAllUsers());
        return "WEB-INF/allUsers.jsp";
    }
}
