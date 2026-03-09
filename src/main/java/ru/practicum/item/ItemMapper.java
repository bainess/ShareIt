package ru.practicum.item;

import ru.practicum.item.dto.ItemDto;
import ru.practicum.item.model.Item;

public final class ItemMapper {
    public static ItemDto itemToDto(Item item) {
        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        return dto;
    }
}
