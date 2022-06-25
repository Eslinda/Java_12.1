package ru.netology.domain;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {

    public int compare(Ticket o1, Ticket o2) {

        if (o1.getPrice() < o2.getPrice()) {
            return -1;
        }
        if ((o1.getPrice() > o2.getPrice())) {
            return 1;
        }

        if (o1.getTime() < o2.getTime()) {
            return -1;
        }
        if ((o1.getTime() == o2.getTime())) {
            return 0;
        }
        return 1;
    }

}
