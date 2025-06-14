package br.com.polvere.service.impl;

import br.com.polvere.controle.dto.ItemDto;
import br.com.polvere.nucleo.Item;
import br.com.polvere.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final HashMap<String, Item> itens;

    @Override
    public Item consultarItem(String id) {
        return itens.get(id);
    }

    @Override
    public String adicionarItem(ItemDto itemDto) {
        String id = UUID.randomUUID().toString();
        itens.put(id ,getItem(itemDto));
        return id;
    }

    @Override
    public void excluirItem(String id) {
        itens.remove(id);
    }

    @Override
    public String calcularTotal() {

        double total = itens.values().stream()
               .mapToDouble(item -> item.getQuantidade() * item.getPrecoUnitario())
               .sum();
        return Double.toString(total);
    }

    private Item getItem(ItemDto itemDto){

        return Item.builder()
                .nome(itemDto.getNome())
                .precoUnitario(itemDto.getPrecoUnitario())
                .quantidade(itemDto.getQuantidade())
                .build();
    }
}
