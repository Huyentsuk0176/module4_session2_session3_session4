package com.example.employee_api.order.controller;

import com.example.employee_api.order.model.Order;
import com.example.employee_api.order.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // tìm theo trạng thái
    @GetMapping("/searchStatus")
    public List<Order> searchByStatus(@RequestParam String status) {
        return orderService.getOrdersByStatus(status);
    }

    // tìm theo tên khách hàng
    @GetMapping("/searchByCustomerName")
    public List<Order> searchByCustomerName(@RequestParam String customerName) {
        return orderService.getOrdersByCustomerName(customerName);
    }
    @GetMapping("/sort")
    public List<Order> sortOrders(@RequestParam String sortBy, @RequestParam String dir){
        return orderService.getAllOrdersSorted(sortBy, dir);
    }
    @GetMapping("/paging")
    public Page<Order> getOrdersPaging(
            @RequestParam int page,
            @RequestParam int size){

        return orderService.getOrdersPaged(page, size);
    }
    @GetMapping("/high-value")
    public List<Order> getHighValueOrders(){
        return orderService.getHighValueOrders();
    }
}
