package za.co.applications.princegains.shopping.shopping.dao;

import org.hibernate.Transaction;
import za.co.applications.princegains.shopping.shopping.model.Order;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;

import java.util.Date;
import java.util.List;

public class OrderDAOImpl extends AbstractDao<Integer, Order> implements OrderDAO {

    private static final OrderDAO INSTANCE = new OrderDAOImpl();

    public static OrderDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Order getOrderById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Order> getOrdersByUser(SystemUser systemUser) {

        return null;
    }

    @Override
    public List<Order> getOrdersWithinDateRange(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public void saveOrder(Order order) {
        Transaction transaction = getSession().beginTransaction();
        getSession().save(order);
        transaction.commit();
    }

    @Override
    public void updateOrder(Order order) {
        Transaction transaction = getSession().beginTransaction();
        getSession().update(order);
        transaction.commit();
    }

    @Override
    public void completeOrder(Order order) {

    }
}