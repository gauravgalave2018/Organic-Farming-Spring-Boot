package com.FarmersFriend.FarmerFrd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FarmersFriend.FarmerFrd.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query(value = "SELECT o.o_id,o.order_timestamp,f.name,f.phone,op.name,op.description,op.price "
            + "FROM user_order o "
            + "JOIN farmer f ON o.f_id = f.f_id "
            + "JOIN org_product op ON o.p_id = op.p_id "
            + "WHERE f.f_id = :fId", nativeQuery = true)
    List<Object[]> findOrderDetails(@Param("fId") int fId);

}
