package com.example.bookretail.controller;

import com.example.bookretail.dto.*;
import com.example.bookretail.model.*;
import com.example.bookretail.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody OrderCreateRequest orderCreateRequest) throws Exception {
        return orderService.createOrder(orderCreateRequest);
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrderDetail(@PathVariable String orderId){
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/list")
    public List<Order> getOrdersByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate stop){
        return orderService.getOrderByOrderDate(start.minusDays(1),stop.plusDays(1));
    }


}
