package za.co.applications.princegains.shopping.shopping.model;

/**
 * Created by kholofelo on 2016/09/14.
 */

public enum StockItemCategory {
    ALL("ALL"),
    FOOD("Food"),
    CLOTHING("Clothing"),
    HEALTH_AND_BEAUTY("Health & Beauty"),
    HOME("Home"),
    Other("Other");


    private final String value;

    StockItemCategory(final String name) {
        this.value = name;
    }

    public String getName() {
        return this.value;
    }

}
