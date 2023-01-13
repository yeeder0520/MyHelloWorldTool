package strategy.discount;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/12/27 下午 04:25
 **/
public abstract class Drink {

    IDiscountStrategy discountStrategy = new NoneDiscount(1);

    double value;

    private Drink() {
    }

    public Drink(double value) {
        this.value = value;
    }

    public Drink(double value, IDiscountStrategy discountStrategy) {
        this.value = value;
        this.discountStrategy = discountStrategy;
    }

    public double getValue() {
        return discountStrategy.getValue(value);
    }

}

