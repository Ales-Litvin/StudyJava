package javarush.task.task17.task1714;

/*
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized static void main(String[] args) {
        System.out.println(
        new Beach("beach1", 10.5f, 100)
                .compareTo(new Beach("beach2", 12.5f, 200)));

        System.out.println(
        new Beach("beach1", 12.5f, 200)
                .compareTo(new Beach("beach2", 10.5f, 100)));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result = 0;

        result = (int) (o.getDistance() - getDistance());

        result = result + (getQuality() - o.getQuality());

        return result;
    }
}