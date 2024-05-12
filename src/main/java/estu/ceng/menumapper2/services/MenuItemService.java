package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.MenuItemDTO;
import estu.ceng.menumapper2.models.MenuItemEntity;

import java.util.List;


public interface MenuItemService {
    long delete(String menuItemName);
    MenuItemDTO update(MenuItemDTO MenuItemDTO);
    List<MenuItemDTO> findAllWithCafeName(String cafeName);
    List<MenuItemDTO> findAllWithMenuItemName(String menuItemName);
    MenuItemDTO save(MenuItemDTO MenuItemDTO);
}
