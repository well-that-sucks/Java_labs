package controller.command;

import model.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

public class Home implements Command {
    private final UserService userService;

    public Home(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            User user = (User) request.getSession().getAttribute("user");
            request.setAttribute("welcome", "Welcome, " + user.getUserName());
            return "WEB-INF/home.jsp";
        }
        return "WEB-INF/home.jsp";
    }
}
