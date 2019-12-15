package pl.irybchuk.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Price {

    private Integer id;
    private PriceUnit priceUnit;
    private BigDecimal basePrice;
    private String currency;

    public Price(Integer id, PriceUnit priceUnit, BigDecimal basePrice, String currency) {
        this.id = id;
        this.priceUnit = priceUnit;
        this.basePrice = basePrice;
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public PriceUnit getPriceUnit() {
        return priceUnit;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public String getCurrency() {
        return currency;
    }
}
