package com.example.bookretail.repository;

import com.example.bookretail.dto.*;
import com.example.bookretail.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,String> {
    List<Order> findByCustomerId(String customerId, Pageable pageable);
    Order findByOrderId(String orderId);
    List<Order> findByOrderDateBetween(LocalDate start,LocalDate stop);

    @Aggregation(pipeline = {"{'$match':{customerId: ?0 }} " ,
            "{ '$group': { _id: '$month',totalPurchasedAmount: { $sum: '$totalAmount'  }, " +
            "orderCount:{$sum: 1} , bookCount:{$sum: '$bookCount'}   }}  " })
    List<StatisticsResponse> getMonthlyStatistics(String customerId);
}
