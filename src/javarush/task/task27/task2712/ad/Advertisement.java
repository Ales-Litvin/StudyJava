package javarush.task.task27.task2712.ad;

// Рекламное объявелние
public class Advertisement {
    // содержание
    private Object content;
    private String name;
    // стоимость рекламы в копейках
    private long initialAmount;
    // количество оплаченых показов
    private int hits;
    // продолжительность
    private int duration;
    // стоимость показа одного рекламеного ролика
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = (hits > 0) ? initialAmount / hits : 0;
    }

    public int getHits() { return hits; }

    public String getName() { return name; }

    public int getDuration() { return duration; }

    public long getAmountPerOneDisplaying() { return amountPerOneDisplaying; }

    public void revalidate(){
        if (hits < 0) throw new UnsupportedOperationException();
        hits -= 1;
    }
}