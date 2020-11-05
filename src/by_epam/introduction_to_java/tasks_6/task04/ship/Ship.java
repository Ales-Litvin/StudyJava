package by_epam.introduction_to_java.tasks_6.task04.ship;


public class Ship {
    // Current download
    private int count;

    // Size of ship
    private Size size;

    // loading or unloading
    private ShipPurpose purpose;

    public Ship(Size size, ShipPurpose purpose) {
        this.size = size;
        this.purpose = purpose;
    }

    public void add(int count){ this.count += count; }

    // returns count of unloaded products
    public int get(int count){
        if (this.count >= count){
            this.count -= count;
        } else {
            count = this.count;
            this.count = 0;
        }
        return count;
    }

    // return true if ship is empty (unnecessary method)
    public boolean isEmpty(){ return count == 0; }

    // return true if ship is full (unnecessary method)
    public boolean isFull(){ return count >= size.getValue(); }

    // return true if I can something to do with ship
    // example: loading or unloading
    public boolean countCheck() { return count < size.getValue() || count != 0; }

    public int getCount() { return count; }

    public Size getSize() { return size; }

    public ShipPurpose getPurpose() { return purpose; }
}
