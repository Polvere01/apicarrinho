package br.com.polvere.service;

import br.com.polvere.controle.dto.ItemDto;
import br.com.polvere.nucleo.Item;

public interface ItemService {
    Item consultarItem(String id);
    String adicionarItem(ItemDto itemDto);
    void excluirItem(String id);
    String calcularTotal();
}
