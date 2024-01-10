package com.neurogine.stores.controller;

import com.neurogine.stores.dto.StoreFilterDTO;
import com.neurogine.stores.dto.StoreResponseDTO;
import com.neurogine.stores.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StoreController {

    private final  StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public ResponseEntity<List<StoreResponseDTO>> getStores(@RequestBody StoreFilterDTO storeFilterDTO) {
        ResponseEntity<List<StoreResponseDTO>> response =  null;
        List<StoreResponseDTO> storeResponseDTOS = storeService.getAllStores(storeFilterDTO);
        try {
            if (storeResponseDTOS.isEmpty()) {
                return new ResponseEntity<>(ResponseEntity.status(HttpStatus.NO_CONTENT).body("No data available");
            } else {
                return new ResponseEntity<>(ResponseEntity.status(HttpStatus.OK).body(storeFilterDTO);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }

    }
}
