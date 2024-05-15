package estu.ceng.menumapper2.controllers;

import estu.ceng.menumapper2.dtos.CafeDTO;
import estu.ceng.menumapper2.services.CafeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CafeController {
    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }
    @PostMapping("add/cafe")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public CafeDTO addCafe(@RequestBody CafeDTO CafeDTO) {
        return cafeService.save(CafeDTO);
    }

    @GetMapping("findAll/cafe")
    public List<CafeDTO> getAll() {
        return cafeService.findAll();
    }

    @DeleteMapping("delete/cafe/{cafeName}")
    public Long deleteCafe(@PathVariable String cafeName) {
        return cafeService.delete(cafeName);
    }

    @GetMapping("get/cafeWithName/{cafeName}")
    public ResponseEntity<CafeDTO> getCafeWithName(@PathVariable String cafeName) {
        CafeDTO CafeDTO = cafeService.findOneWithCafeName(cafeName);
        if (CafeDTO == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(CafeDTO);
    }

    @GetMapping("get/cafeWithAddress/{lon}/{lat}")
    public ResponseEntity<List<CafeDTO>> getCafeWithAddress(@PathVariable double lon, @PathVariable double lat) {
        List<CafeDTO> cafesInArea = cafeService.findCafeWithAddress(lon,lat);
        if (cafesInArea == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(cafesInArea);
    }

    @PutMapping("/update/cafe")
    public CafeDTO updateCafe(@RequestBody CafeDTO CafeDTO) {
        return cafeService.update(CafeDTO);
    }



}
