package estu.ceng.menumapper2.services;

import estu.ceng.menumapper2.dtos.MenuItemDTO;
import estu.ceng.menumapper2.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService{

    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public long delete(String menuItemName) {
        return menuItemRepository.delete(menuItemName);
    }

    @Override
    public MenuItemDTO update(MenuItemDTO MenuItemDTO) {
        return new MenuItemDTO(menuItemRepository.update(MenuItemDTO.toMenuItemEntity()));
    }

    @Override
    public List<MenuItemDTO> findAllWithCafeName(String cafeName) {
        return menuItemRepository.findAllWithCafeName(cafeName).stream().map(MenuItemDTO::new).toList();
    }

    @Override
    public List<MenuItemDTO> findAllWithMenuItemName(String menuItemName,boolean asc) {
        return menuItemRepository.findAllWithMenuItemName(menuItemName, asc).stream().map(MenuItemDTO::new).toList();
    }

    @Override
    public MenuItemDTO save(MenuItemDTO MenuItemDTO) {
        return new MenuItemDTO(menuItemRepository.save(MenuItemDTO.toMenuItemEntity()));
    }

    @Override
    public List<MenuItemDTO> findAllWithCategoryName(String categoryName) {
        return menuItemRepository.findAllWithCategoryName(categoryName).stream().map(MenuItemDTO::new).toList();
    }
}


