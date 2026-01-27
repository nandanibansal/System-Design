package entities;

public class Item {
    ItemType item;
    int price;

    public ItemType getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }

    public void setItem(ItemType item) {
        this.item = item;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
