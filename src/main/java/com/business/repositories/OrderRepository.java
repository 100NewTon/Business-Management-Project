package com.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.entities.Orders;
import com.business.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>
{
	List<Orders> findOrdersByUser(User user);
}
