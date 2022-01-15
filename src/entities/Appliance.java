package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Appliance extends BaseEntity {
    private String model;
    private LocalDate productionDate;
    private BigDecimal weight;

    public Appliance() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate
                                          productionDate) {
        this.productionDate = productionDate;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
