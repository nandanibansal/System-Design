package Product;

import java.time.LocalDate;
import java.util.Date;

public class DateInterval {
    LocalDate dateFrom, dateTo;

    public DateInterval(LocalDate dateFrom, LocalDate dateTo){
        if(dateTo.isBefore(dateFrom)){
            throw new IllegalArgumentException("Date invalid");
        }
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public boolean isOverlap(DateInterval other){
        return !((this.dateTo.isBefore(other.dateFrom) || this.dateFrom.isAfter(other.dateTo)));
    }
}
