package entities;

import java.time.LocalDate;

public class Food extends BaseEntity {
    private LocalDate expirationDate;

    public Food() {
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
