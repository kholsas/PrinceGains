package za.co.applications.princegains.shopping.shopping.service.impl;

import za.co.applications.princegains.shopping.shopping.dao.OrderDAO;
import za.co.applications.princegains.shopping.shopping.dao.OrderDAOImpl;
import za.co.applications.princegains.shopping.shopping.model.Order;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.service.OrderService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/13.
 */
public class OrderServiceImpl implements OrderService {

    private static final OrderService INSTANCE = new OrderServiceImpl();
    private static final OrderDAO ORDER_DAO = new OrderDAOImpl();
    public static OrderService getInstance(){
        return INSTANCE;
    }

    @Override
    public List<Order> getOrdersByPerson(SystemUser systemUser) {
        return ORDER_DAO.getOrdersByUser(systemUser);
    }

    @Override
    public List<Order> getOrderByDateRange(Timestamp startDateTime, Timestamp endDateTime) {
        return null;
    }

    @Override
    public void makeAnOrder(Order order) {
        ORDER_DAO.saveOrder(order);
    }

    @Override
    public void updateAnOrder(Order order) {
        ORDER_DAO.updateOrder(order);
    }

    @Override
    public Order getAnOrder(int id) {
        return ORDER_DAO.getOrderById(id);
    }
}
