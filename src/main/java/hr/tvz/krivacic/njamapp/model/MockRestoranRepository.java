package hr.tvz.krivacic.njamapp.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
@Profile("prod")
@Repository
public class MockRestoranRepository implements RestoranRepository{
    private final List<Restoran> restorani = Arrays.asList(
            new Restoran(1L, "Restoran1", "Adresa1", "123456", "rest1@gmail.com",
                    createRadnoVrijeme(), true, 30, 4.5, 10),
            new Restoran(2L, "Restoran2", "Adresa2", "654321", "rest2@gmail.com",
                    createRadnoVrijeme(), true, 25, 4.0, 15)
    );

    public MockRestoranRepository(){

    }
    @Override
    public List<Restoran> findAll() {
        return new ArrayList<>(restorani);
    }

    @Override
    public Optional<Restoran> findRestoranByID(Long id) {
        return restorani.stream()
                .filter(r -> r.getID().equals(id)).findFirst();
    }

    private static Map<String, String> createRadnoVrijeme() {
        Map<String, String> radnoVrijeme = new HashMap<>();
        radnoVrijeme.put("Monday", "10:00-22:00");
        radnoVrijeme.put("Tuesday", "10:00-22:00");
        radnoVrijeme.put("Wednesday", "10:00-22:00");
        radnoVrijeme.put("Thursday", "10:00-22:00");
        radnoVrijeme.put("Friday", "10:00-22:00");
        radnoVrijeme.put("Saturday", "10:00-22:00");
        radnoVrijeme.put("Sunday", "10:00-22:00");
        return radnoVrijeme;
    }
}
