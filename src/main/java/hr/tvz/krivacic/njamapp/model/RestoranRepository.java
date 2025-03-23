package hr.tvz.krivacic.njamapp.model;

import java.util.List;
import java.util.Optional;

public interface RestoranRepository {
    List<Restoran> findAll();
    Optional<Restoran> findRestoranByID(Long id);
}
