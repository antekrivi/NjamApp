package hr.tvz.krivacic.njamapp.controller.rest;

import hr.tvz.krivacic.njamapp.model.RestoranDTO;
import hr.tvz.krivacic.njamapp.model.RestoranService;
import hr.tvz.krivacic.njamapp.model.RestoranServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restoran")
public class RestoranController {
    private static final Logger logger = LoggerFactory.getLogger(RestoranController.class);
    private final RestoranServiceImpl restoranServiceImpl;

    public RestoranController(RestoranServiceImpl restoranServiceImpl) {
        this.restoranServiceImpl = restoranServiceImpl;
    }

    @GetMapping()
    public List<RestoranDTO> getAllRestorani(){
        return restoranServiceImpl.findAll();
    }

    @GetMapping(params = "id")
    public RestoranDTO getRestoranById(@RequestParam final Long id){
        return restoranServiceImpl.findRestoranByID(id);
    }


}
