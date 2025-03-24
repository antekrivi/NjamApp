package hr.tvz.krivacic.njamapp.model;

import java.util.List;

public interface RestoranService {
    List<RestoranDTO> findAll();
    RestoranDTO findRestoranByID(Long id);
    List<RestoranDTO> findNajblizi(String adresa, Double ocjena);
    List<RestoranDTO> findNajbolji(Double ocjena);
}
