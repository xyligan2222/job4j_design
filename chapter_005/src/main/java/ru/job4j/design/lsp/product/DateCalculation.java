package ru.job4j.design.lsp.product;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateCalculation {
    public static long dateDifference(LocalDateTime dateCreated, LocalDateTime dateExpired) throws IOException {
        if (dateCreated == null || dateExpired == null ) {
            throw new IOException();
        }
        long dataBegin = dateCreated.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
        long dataEnd = dateExpired.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
        return dataEnd - dataBegin;
    }

    public static long createDateBetweenDateNow(LocalDateTime createDate) throws IOException {
        if (createDate == null) {
            throw new IOException();
        }

        return System.currentTimeMillis() - createDate.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
    }

    public static int percent(LocalDateTime createDate, LocalDateTime expaireDate) throws IOException {
        if (createDateBetweenDateNow(expaireDate) < 0) {
            return  (int) (100 - ((-100 * DateCalculation.createDateBetweenDateNow(expaireDate))
                    / DateCalculation.dateDifference(createDate, expaireDate)));
        }
        return -1;
    }

}
