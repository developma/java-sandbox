package oreore.tool.detector.target;

import javax.xml.ws.soap.Addressing;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.Date;

public class Target {
    Date date;
    LocalDate localDate;

    @Deprecated
    public Date getDate() {
        return date;
    }

    @Transient
    public void setDate(Date date) {
        this.date = date;
    }

    @Addressing
    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
