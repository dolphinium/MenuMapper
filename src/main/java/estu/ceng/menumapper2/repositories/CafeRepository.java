package estu.ceng.menumapper2.repositories;

import estu.ceng.menumapper2.models.CafeEntity;

import java.util.List;

public interface CafeRepository {
    long delete(String cafeName);
    CafeEntity update(CafeEntity cafeEntity);
    List<CafeEntity> findAll();
    CafeEntity save(CafeEntity cafeEntity);
    CafeEntity findOneWithCafeName(String cafeName);
}
