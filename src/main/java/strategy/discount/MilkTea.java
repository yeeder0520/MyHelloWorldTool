package strategy.discount;

//奶茶
public class MilkTea extends Drink {
    public MilkTea(double value) {
        super(value);
    }

    public MilkTea(double value, IDiscountStrategy discountStrategy) {
        super(value, discountStrategy);
    }

    @Override
    public double getValue() {
        return super.getValue();
    }
}
