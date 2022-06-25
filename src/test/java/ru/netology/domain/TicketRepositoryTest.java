package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketRepositoryTest {

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


    @Test
    public void shouldSaveAll() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);

        Ticket[] actual = repo.findAll();
        Ticket[] execution = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        assertArrayEquals(actual, execution);
    }

    @Test
    public void shouldRemoveId() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);

        repo.removeById(73);
        Ticket[] actual = repo.findAll();
        Ticket[] execution = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket7, ticket8, ticket9, ticket10};
        assertArrayEquals(actual, execution);
    }


}
