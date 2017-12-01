package com.example.demo;

import com.example.demo.Entities.Order;
import com.example.demo.Repositories.OrderDAO;
import com.example.demo.Services.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Mock
	private OrderDAO orderDAO;


	@InjectMocks
	private OrderService orderService;

	private Order order;
	@Before
	public void init(){
		order = new Order();
		order.setAmount(new BigDecimal(10));
		order.setQuantity(1);
		order.setInventoryId("1");
		order.setCreditCardNumber("123456");
	}

	@Test
	public void testGetOrder(){
		when(orderDAO.getOrderByOrderId(order.getOrderId())).thenReturn(order);

		assertEquals(order.getOrderId(), orderService.getOrder(order.getOrderId()).getOrderId());


	}

}
