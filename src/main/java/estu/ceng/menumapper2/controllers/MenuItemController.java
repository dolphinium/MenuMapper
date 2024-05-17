package estu.ceng.menumapper2.controllers;

import estu.ceng.menumapper2.dtos.MenuItemDTO;
import estu.ceng.menumapper2.services.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuItemController {
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PreAuthorize("hasRole('CAFE_HOLDER')")
    @PostMapping("add/menuItem")
    @ResponseStatus(HttpStatus.CREATED)
    public MenuItemDTO addMenuItem(@RequestBody MenuItemDTO MenuItemDTO) {
        return menuItemService.save(MenuItemDTO);
    }

    @PreAuthorize("hasRole('USER') or hasRole('CAFE_HOLDER') or hasRole('ADMIN')")
    @GetMapping("findAll/menuItemWithName/{menuItemName}/{asc}")
    public List<MenuItemDTO> findAllWithMenuItemName(@PathVariable String menuItemName, @PathVariable boolean asc ) {
        return menuItemService.findAllWithMenuItemName(menuItemName,asc);
    }

    @PreAuthorize("hasRole('USER') or hasRole('CAFE_HOLDER') or hasRole('ADMIN')")
    @GetMapping("findAll/menuItemWithCategory/{categoryName}")
    public List<MenuItemDTO> findAllWithCategoryName(@PathVariable String categoryName) {
        return menuItemService.findAllWithCategoryName(categoryName);
    }

    @PreAuthorize("hasRole('USER') or hasRole('CAFE_HOLDER') or hasRole('ADMIN')")
    @GetMapping("findAll/menuItemWithCafeName/{cafeName}")
    public List<MenuItemDTO> findAllWithCafeName(@PathVariable String cafeName) {
        return menuItemService.findAllWithCafeName(cafeName);
    }

    @PreAuthorize("hasRole('CAFE_HOLDER') or hasRole('ADMIN')")
    @DeleteMapping("/delete/menuItem/{menuItemName}")
    public long deleteMenuItem(@PathVariable String menuItemName){
        return menuItemService.delete(menuItemName);
    }

    @PreAuthorize("hasRole('CAFE_HOLDER') or hasRole('ADMIN')")
    @PutMapping("/update/menuItem")
    public MenuItemDTO updateMenuItem(@RequestBody MenuItemDTO MenuItemDTO) {
        return menuItemService.update(MenuItemDTO);
    }

}
