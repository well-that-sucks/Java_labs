package controller.command.admin;

import controller.command.Command;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

public class ManagerRoleHandler implements Command {
    private final UserService userService;

    public ManagerRoleHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getParameter("userId"));
        try {
            userService.managerRoleHandler(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
        return "redirect:/allUsers";
    }
}
