package estu.ceng.menumapper2.controllers;

import estu.ceng.menumapper2.dtos.MenuItemDTO;
import estu.ceng.menumapper2.services.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuItemController {
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping("add/menuItem")
    @ResponseStatus(HttpStatus.CREATED)
    public MenuItemDTO addMenuItem(@RequestBody MenuItemDTO MenuItemDTO) {
        return menuItemService.save(MenuItemDTO);
    }

    @GetMapping("findAll/menuItemWithName/{menuItemName}")
    public List<MenuItemDTO> findAllWithMenuItemName(@PathVariable String menuItemName) {
        return menuItemService.findAllWithMenuItemName(menuItemName);
    }

    @GetMapping("findAll/menuItemWithCafeName/{cafeName}")
    public List<MenuItemDTO> findAllWithCafeName(@PathVariable String cafeName) {
        return menuItemService.findAllWithCafeName(cafeName);
    }

    @DeleteMapping("/delete/menuItem/{menuItemName}")
    public long deleteMenuItem(@PathVariable String menuItemName){
        return menuItemService.delete(menuItemName);
    }

    @PutMapping("/update/menuItem")
    public MenuItemDTO updateMenuItem(@RequestBody MenuItemDTO MenuItemDTO) {
        return menuItemService.update(MenuItemDTO);
    }

}
