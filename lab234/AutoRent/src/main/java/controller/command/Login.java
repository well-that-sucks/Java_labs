package controller.command;

import model.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Login implements Command {
	static final Logger LOGGER = Logger.getLogger(Login.class);
	
    private final UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            return "WEB-INF/login.jsp";
        }

        Optional<User> user;

        try {
            user = userService.findByUserName(request.getParameter("userName"));
            if (user.get().getActive()) {
                boolean correctPass = userService.checkPasswordMatching(request.getParameter("password"), user.get());
                if (user.isPresent() && correctPass) {
                    CommandSecurity.addUserSession(request, user.get());
                    LOGGER.info("Successfully executed login command");
                    return "redirect:/home";
                }

                if (user.isPresent() && !correctPass) {
                    request.setAttribute("wrongPassword", "Password is not correct");
                    return "WEB-INF/login.jsp";
                }
                
            } else {
                request.setAttribute("userBanned", "You're banned");
                return "WEB-INF/login.jsp";
            }


        } catch (NoSuchElementException ex) {
            request.setAttribute("wrongUserName", "Username not found");
            return "WEB-INF/login.jsp";
        } catch (Exception e) {
        	LOGGER.error("An error occured during executing login command");
            e.printStackTrace();
            return "WEB-INF/login.jsp";
        }
        return "WEB-INF/login.jsp";

    }
}
