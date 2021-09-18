package com.example.bookretail.service;

import com.example.bookretail.dto.*;
import com.example.bookretail.exception.*;
import com.example.bookretail.model.*;
import com.example.bookretail.repository.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.math.*;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    private void validateOrder(OrderCreateRequest request){
        if (request.getBookCount() <= 0){
            throw new CountMustGreaterThanZero("Book storage is insufficient");
        }
    }

    @Transactional
    public Order createOrder(OrderCreateRequest request) throws Exception {
        validateOrder(request);
        Book book = bookService.findById(request.getBookId());
        Customer customer = customerService.findByCustomerId(request.getCustomerId());
        if (book.getStock() < request.getBookCount()){
            throw new NotEnoughStockException("Book storage is insufficient.");
        }

        book.decrementStock(request.getBookCount());
        bookService.saveBook(book);
        Order newOrder = new Order(customer.getCustomerId(),book,request.getBookCount());
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setTotalAmount(book.getPrice().multiply(new BigDecimal(request.getBookCount())));
        newOrder.setMonth(newOrder.getOrderDate().getMonthValue());
        orderRepository.save(newOrder);
        customerService.saveCustomer(customer);
        return newOrder;
    }


    public List<OrderListResponse> getCustomerOrders(String customerId,Pageable pageable){
        return orderRepository.findByCustomerId(customerId,pageable)
                .stream().map(order -> new OrderListResponse(order.getBook().getBookName(),order.getBookCount()))
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(String orderId){
        Order orderEntity = orderRepository.findByOrderId(orderId);
        if (orderEntity == null) {
            throw new NotFoundException("Order not found:"+orderId);
        }
        Customer customer = customerService.findByCustomerId(orderEntity.getCustomerId());
        Book book = bookService.findById(orderEntity.getBook().getBookId());
        return new OrderResponse(customer.getFirstName(),customer.getLastName(),
                book.getBookName(),orderEntity.getBookCount(),orderEntity.getOrderDate());
    }

    public List<Order> getOrderByOrderDate(LocalDate start, LocalDate stop){
        return orderRepository.findByOrderDateBetween(start,stop);
    }

    public List<StatisticsResponse> getMonthlyStatistics(String customerId){
        return orderRepository.getMonthlyStatistics(customerId).stream().map(statisticsResponse -> {
            String month = new DateFormatSymbols().getMonths()[statisticsResponse.get_id()];
            statisticsResponse.setMonth(month);
            return statisticsResponse;
        }).collect(Collectors.toList());
    }
}
