package dnd;

import java.util.List;
import java.util.ArrayList;

public class Mochila {

    private List<Item> items;

    public Mochila() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            items.remove(index);
        }
    }
    public void listarItems(){
        for (Item item : this.items) {
            System.out.println(item.getNombre());
        }
    }
}
