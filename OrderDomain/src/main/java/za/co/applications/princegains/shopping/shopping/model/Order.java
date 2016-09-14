package za.co.applications.princegains.shopping.shopping.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by kholofelo on 2016/09/08.
 */

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Timestamp orderTime;

    @Column
    private Timestamp processedTime;
    @Column
    private Timestamp deliveredTime;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private SystemUser systemUser;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_item_id")
    private List<StockItem> stockItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }

    public Timestamp getProcessedTime() {
        return processedTime;
    }

    public void setProcessedTime(Timestamp processedTime) {
        this.processedTime = processedTime;
    }

    public Timestamp getDeliveredTime() {
        return deliveredTime;
    }

    public void setDeliveredTime(Timestamp deliveredTime) {
        this.deliveredTime = deliveredTime;
    }
}
