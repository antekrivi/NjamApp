package hr.tvz.krivacic.njamapp.controller.rest;

import hr.tvz.krivacic.njamapp.model.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranService;
import hr.tvz.krivacic.njamapp.model.RestoranServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/restoran")
public class RestoranController {
    private final RestoranServiceImpl restoranServiceImpl;

    public RestoranController(RestoranServiceImpl restoranServiceImpl) {
        this.restoranServiceImpl = restoranServiceImpl;
    }

    @GetMapping("/all")
    public List<RestoranDTO> getAllRestorani(){
        return restoranServiceImpl.findAll();
    }

    @GetMapping("/id")
    public RestoranDTO getRestoranById(Long id){
        return restoranServiceImpl.findRestoranByID(id);
    }


}
