package controller.command;

import service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class AllOrders implements Command {

    private final OrderService orderService;

    public AllOrders(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("orders",  orderService.findAll());
        return "WEB-INF/allOrders.jsp";
    }
}
