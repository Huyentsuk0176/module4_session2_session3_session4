package com.example.employee_api.order.repository;

import com.example.employee_api.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //tim don hang theo trang thai
    List<Order>
    findByStatus(String status);
    //tim theo ten khach hang
    List<Order>
    findByCustomerNameContaining(String customerName);
    @Query("""
       SELECT o FROM Order o
       WHERE MONTH(o.createdAt) = MONTH(CURRENT_DATE)
       AND YEAR(o.createdAt) = YEAR(CURRENT_DATE)
       AND o.totalPrice > (
            SELECT AVG(o2.totalPrice)
            FROM Order o2
            WHERE MONTH(o2.createdAt) = MONTH(CURRENT_DATE)
            AND YEAR(o2.createdAt) = YEAR(CURRENT_DATE)
       )
       """)
    List<Order> findHighValueOrders();
}
