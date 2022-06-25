package ru.netology.domain;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findAllTime(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.findAll()) {
            Ticket[] tmp = new Ticket[result.length + 1];
            if (ticket.getFrom() == from && ticket.getTo() == to) {
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
