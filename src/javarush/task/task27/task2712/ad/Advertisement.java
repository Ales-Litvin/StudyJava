package javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;// - видео
    private String name;// - имя/название
    private long initialAmount;// - начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits;// - количество оплаченных показов
    private int duration;// - продолжительность в секундах
    private long amountPerOneDisplaying;

    public String getName() { return name; }

    public int getDuration() { return duration; }

    public long getAmountPerOneDisplaying() { return amountPerOneDisplaying; }

    public int getHits() { return hits; }

    public long getAmountPerSecond() {
        // Те самые тысячные доли копейки за секунду
        return amountPerOneDisplaying * 1000 / duration;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public void revalidate() throws UnsupportedOperationException {
        if(hits <= 0)
            throw new UnsupportedOperationException();
        hits--;
    }
}