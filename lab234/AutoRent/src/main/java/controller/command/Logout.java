package controller.command;

import model.User;

import javax.servlet.http.HttpServletRequest;

public class Logout implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        CommandSecurity.destroyUserSession(request, user.getUserName());
        return "WEB-INF/login.jsp";
    }
}
