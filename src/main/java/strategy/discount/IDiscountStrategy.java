package strategy.discount;

/**
 * 關於特價策略三種，減價、打折、不折價。
 *
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/12/27 下午 04:21
 **/
public abstract class IDiscountStrategy {
    double discount;

    private IDiscountStrategy() {
    }

    public IDiscountStrategy(double discount) {
        this.discount = discount;
    }

    abstract public double getValue(double value);

}

