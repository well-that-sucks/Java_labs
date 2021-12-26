package controller.command;

import model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class CommandSecurity {
    public static void addUserSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        HashSet<String> loggedUsers = (HashSet<String>)context.getAttribute("loggedUsers");
        loggedUsers.add(user.getUserName());

        context.setAttribute("loggedUsers", loggedUsers);
        session.setAttribute("user", user);
        session.setAttribute("userRole", user.getRole().name());
    }

    public static void destroyUserSession(HttpServletRequest request, String userName) {
        HashSet<String> loggedUsers = (HashSet<String>)request.getServletContext().getAttribute("loggedUsers");
        HttpSession session = request.getSession();

        loggedUsers.remove(userName);
        session.removeAttribute("user");
        session.removeAttribute("userRole");

        request.getServletContext().setAttribute("loggedUsers", loggedUsers);
    }
}
