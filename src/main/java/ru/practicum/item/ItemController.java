package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.item.dto.ItemDto;
import ru.practicum.item.model.Item;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    //TODO: должен возращать только доступные вещи
    @GetMapping("/search")
    public List<Item> searchItems(@RequestParam(name="text") String text) {
        return itemService.searchItems(text);
    }


    @GetMapping
    public List<Item> getItemsByUser(@RequestHeader("X-Sharer-User-Id") Long userId) {
        return itemService.findAllItemsByUser(userId);
    }

    @GetMapping
    public Item getItemByUserAndItem(@RequestHeader("X-Sharer-User-Id") Long userId,
                                     @PathVariable(name="itemId") Long itemId) {
        return itemService.getItemByUserAndItem(userId, itemId);
    }

    @GetMapping("/{itemId}")
    public ItemDto getItemById(@PathVariable(name="itemId") Long itemId) {
        return itemService.getItemById(itemId);
    }

    @PostMapping
    public Item addItem(@RequestHeader("X-Sharer-User-Id") Long userId,
                                @RequestBody Item item) {
        return itemService.saveItem(item);
    }
    @PatchMapping("/{itemId}")
    public Item updateItem(@RequestHeader("X-Sharer-User-Id") Long userId,
                                   @RequestBody Item item) {
        return itemService.updateItem(item);
    }
}
