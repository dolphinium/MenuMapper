package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.CafeDTO;
import estu.ceng.menumapper2.dtos.UserDTO;
import estu.ceng.menumapper2.repositories.CafeRepository;
import estu.ceng.menumapper2.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CafeServiceImpl implements CafeService{

    private final CafeRepository cafeRepository;

    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public long delete(String cafeName) {
        return cafeRepository.delete(cafeName);
    }

    @Override
    public CafeDTO update(CafeDTO CafeDTO) {
        return new CafeDTO(cafeRepository.update(CafeDTO.toCafeEntity()));
    }

    @Override
    public List<CafeDTO> findAll() {
        return cafeRepository.findAll().stream().map(CafeDTO::new).toList();
    }

    @Override
    public CafeDTO save(CafeDTO CafeDTO) {
        return new CafeDTO(cafeRepository.save(CafeDTO.toCafeEntity()));
    }

    @Override
    public CafeDTO findOneWithCafeName(String cafeName) {
        return new CafeDTO(cafeRepository.findOneWithCafeName(cafeName));
    }
}
