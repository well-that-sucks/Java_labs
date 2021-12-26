package controller.command;

import javax.servlet.http.HttpServletRequest;

public class ErrorPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            return "WEB-INF/error.jsp";
        }
        return "WEB-INF/error.jsp";
    }
}
