package estu.ceng.menumapper2.repositories;

import estu.ceng.menumapper2.models.MenuItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository {
    long delete(String menuItemName);
    MenuItemEntity update(MenuItemEntity menuItemEntity);
    List<MenuItemEntity> findAllWithCafeName(String cafeName);
    List<MenuItemEntity> findAllWithMenuItemName(String menuItemName);
    MenuItemEntity save(MenuItemEntity menuItemEntity);

}
