package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    Ticket ticket1 = new Ticket(15, 7500, "LED", "UFA", 165);
    Ticket ticket2 = new Ticket(548, 12000, "LED", "ARH", 85);
    Ticket ticket3 = new Ticket(28, 3450, "DME", "KGD", 165);
    Ticket ticket4 = new Ticket(679, 5700, "LED", "UFA", 195);
    Ticket ticket5 = new Ticket(7, 6820, "LED", "ARH", 90);
    Ticket ticket6 = new Ticket(73, 16800, "LED", "UFA", 175);
    Ticket ticket7 = new Ticket(123, 26000, "DME", "KGD", 175);
    Ticket ticket8 = new Ticket(94, 6800, "LED", "UFA", 155);
    Ticket ticket9 = new Ticket(38, 5400, "LED", "DME", 72);
    Ticket ticket10 = new Ticket(112, 5700, "LED", "UFA", 155);
    Ticket ticket11 = new Ticket(33, 6820, "LED", "ARH", 80);
    TicketManager manager = new TicketManager(repo);


    TicketByPriceAscComparator ticketByPriceAscComparator = new TicketByPriceAscComparator();


    @Test
    public void shouldFindAndSortTwoElements() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.findAll("DME", "KGD");
        Ticket[] expected = {ticket3, ticket7};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAndSort() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Ticket[] actual = manager.findAll("LED", "UFA");
        Ticket[] expected = {ticket4, ticket10, ticket8, ticket1, ticket6};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAndSortPriceAndTime() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        Ticket[] actual = manager.findAllTime("LED", "ARH", ticketByPriceAscComparator);
        Ticket[] expected = {ticket11, ticket5, ticket2};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAndSortPriceAndTimeNull() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Ticket[] actual = manager.findAllTime("KGD", "UFA", ticketByPriceAscComparator);
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAndSortOneElement() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.findAll("LED", "DME");
        Ticket[] expected = {ticket9};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindAndSortNull() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.findAll("ARH", "DME");
        Ticket[] expected = {};

        assertArrayEquals(actual, expected);
    }
}

