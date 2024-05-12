package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.CafeDTO;

import java.util.List;

public interface CafeService {
    long delete(String cafeName);
    CafeDTO update(CafeDTO CafeDTO);
    List<CafeDTO> findAll();
    CafeDTO save(CafeDTO CafeDTO);
    CafeDTO findOneWithCafeName(String cafeName);

}
