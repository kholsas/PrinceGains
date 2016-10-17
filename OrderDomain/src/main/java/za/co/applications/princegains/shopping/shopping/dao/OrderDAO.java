package za.co.applications.princegains.shopping.shopping.dao;

import za.co.applications.princegains.shopping.shopping.model.Order;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;

import java.util.Date;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/13.
 */
public interface OrderDAO {

    Order getOrderById(int id);

    List getOrdersByUser(SystemUser systemUser);

    List<Order> getOrdersWithinDateRange(Date startDate, Date endDate);

    void saveOrder(Order order);

    void updateOrder(Order order);

    void completeOrder(Order order);
}
