package entities;

import java.time.LocalDate;

public class Beverage extends BaseEntity {
    private LocalDate expirationDate;

    public Beverage() {
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
