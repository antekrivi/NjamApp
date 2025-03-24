package hr.tvz.krivacic.njamapp.model;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestoranServiceImpl implements RestoranService{
    private final RestoranRepository restoranRepository;

    public RestoranServiceImpl(RestoranRepository restoranRepository) {
        this.restoranRepository = restoranRepository;
    }
    @Override
    public List<RestoranDTO> findAll() {
        return restoranRepository.findAll()
                .stream()
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }
    private RestoranDTO mapRestoranToRestoranDTO(Restoran restoran) {
        return new RestoranDTO(restoran);
    }
    @Override
    public RestoranDTO findRestoranByID(Long id) {
        return restoranRepository.findRestoranByID(id)
                .map(this::mapRestoranToRestoranDTO)
                .orElse(null);
    }

    @Override
    public List<RestoranDTO> findNajblizi(String adresa, Double ocjena) {
        return restoranRepository.findAll()
                .stream()
                .filter(restoran -> restoran.getProsOcjenaKupca() > ocjena && restoran.getAdresa().contains(adresa))
                .map(this::mapRestoranToRestoranDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestoranDTO> findNajbolji(Double ocjena) {
        return null;
    }
}
