package ru.practicum.item;

import org.springframework.stereotype.Service;
import ru.practicum.exception.NotFoundException;
import ru.practicum.item.dto.ItemDto;
import ru.practicum.item.model.Item;

@Service
public class ItemService {
    private ItemInMemoryRepository itemRepository;

    public ItemService(ItemInMemoryRepository itemRepository) {
        this.itemRepository = itemRepository;
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

}
