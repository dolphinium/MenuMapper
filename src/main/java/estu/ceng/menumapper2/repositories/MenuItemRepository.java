package estu.ceng.menumapper2.repositories;

import estu.ceng.menumapper2.models.MenuItemEntity;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.Collection;
import java.util.List;

@Repository
public interface MenuItemRepository {
    long delete(String menuItemName);
    MenuItemEntity update(MenuItemEntity menuItemEntity);
    List<MenuItemEntity> findAllWithCafeName(String cafeName);
    List<MenuItemEntity> findAllWithMenuItemName(String menuItemName, boolean asc);
    MenuItemEntity save(MenuItemEntity menuItemEntity);

    List<MenuItemEntity> findAllWithCategoryName(String categoryName);
}
