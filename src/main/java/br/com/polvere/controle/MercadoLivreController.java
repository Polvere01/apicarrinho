package br.com.polvere.controle;

import br.com.polvere.controle.dto.ItemDto;
import br.com.polvere.nucleo.Item;
import br.com.polvere.service.ItemService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/item")
@RequiredArgsConstructor
public class MercadoLivreController {

    private final ItemService itemService;

    @GetMapping("consultar")
    public ResponseEntity<ItemDto> consultarItem(@RequestParam String id){
        Item itemRetornado = itemService.consultarItem(id);
        return new ResponseEntity<>(getIemDto(itemRetornado), HttpStatus.OK);
    }

    @PostMapping("adicionar")
    public ResponseEntity<String> adicionarItem(@RequestBody ItemDto itemDto){
        String idRetornado = itemService.adicionarItem(itemDto);
        return new ResponseEntity<>(idRetornado, HttpStatus.CREATED);
    }

    @DeleteMapping("excluir")
    public ResponseEntity<?> delelarItem(@RequestParam String id){
        itemService.excluirItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("calcularTotal")
    public ResponseEntity<String> calcularTotal(){
        return new ResponseEntity<>(itemService.calcularTotal(), HttpStatus.OK);
    }


    private ItemDto getIemDto(Item item){
        return ItemDto.builder()
                .nome(item.getNome())
                .precoUnitario(item.getPrecoUnitario())
                .quantidade(item.getQuantidade())
                .build();
    }
}
