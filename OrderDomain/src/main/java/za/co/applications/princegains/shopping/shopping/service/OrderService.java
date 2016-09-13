package za.co.applications.princegains.shopping.shopping.service;

import za.co.applications.princegains.shopping.shopping.model.Order;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/08.
 */
public interface OrderService {

    List<Order> getOrdersByPerson(SystemUser systemUser);

    List<Order> getOrderByDateRange(Timestamp startDateTime, Timestamp endDateTime);

    void makeAnOrder(Order order);

    void updateAnOrder(Order order);

    Order getAnOrder(int id);
}
