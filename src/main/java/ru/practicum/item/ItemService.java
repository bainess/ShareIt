package ru.practicum.item;

import org.springframework.stereotype.Service;
import ru.practicum.exception.NotFoundException;
import ru.practicum.item.dto.ItemDto;
import ru.practicum.item.model.Item;

import java.util.List;

@Service
public class ItemService {
    private ItemInMemoryRepository itemRepository;

    public ItemService(ItemInMemoryRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllItemsByUser(Long userId) {
        return itemRepository.getAllItemsByUser(userId).orElseThrow(() -> new NotFoundException("Items not found"));
    }

    public Item updateItem(Item item) {
       return itemRepository.updateItem(item);
    }

    public Item saveItem(Item item) {
        return itemRepository.saveItem(item);
    }

    public ItemDto getItemById(Long id) {
        return itemRepository.getItem(id)
                .map(ItemMapper::itemToDto)
                .orElseThrow(() -> new NotFoundException ("Item was not found"));
    }

    public List<ItemDto> searchItems(String text) {
        List<ItemDto> itemsFound = itemRepository.searchForItem(text).stream()
                .map(ItemMapper::itemToDto)
                .toList();

        if (itemsFound == null) {
            new NotFoundException("No item matching description was found");
        };

        return itemsFound;

    }
}
