package ru.practicum.item;

import org.springframework.stereotype.Repository;
import ru.practicum.item.model.Item;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class ItemInMemoryRepository {
    private HashMap<Long, Item> items;

    public ItemInMemoryRepository() {
        this.items = new HashMap<>();
    }

    public Item saveItem(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    public Item updateItem(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    public void removeItem(Long itemId) {
        items.remove(itemId);
    }

    public Optional<Item> getItem(Long itemId) {
        return Optional.ofNullable(items.get(itemId));
    }
}
