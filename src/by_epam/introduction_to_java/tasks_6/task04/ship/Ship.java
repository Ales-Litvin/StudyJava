package by_epam.introduction_to_java.tasks_6.task04.ship;


public class Ship {
    // Current download
    private int count;

    // Size of ship
    private final Size size;

    // loading or unloading
    private final ShipPurpose purpose;

    public Ship(Size size, ShipPurpose purpose) {
        this.size = size;
        if (purpose == ShipPurpose.UNLOADING){
            this.count = size.getValue();
        }
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

    // return true if the ship can unloads 'containers'
    public boolean canUnloads(){ return count > 0; }

    // return true if ship can loads 'containers'
    public boolean canLoads(){ return count < size.getValue(); }

    // return true if I can something to do with ship
    // example: loading or unloading
    public boolean countCheck() {
        if (purpose == ShipPurpose.LOADING) return canLoads();
        else return canUnloads();
    }

    public int getCount() { return count; }

    public Size getSize() { return size; }

    public ShipPurpose getPurpose() { return purpose; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ship{");
        sb.append(count);
        sb.append(", ").append(size);
        sb.append(", ").append(purpose);
        sb.append('}');
        return sb.toString();
    }
}
