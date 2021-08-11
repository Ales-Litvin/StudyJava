package javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 2;
    }

    @Override
    public String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                Country.UKRAINE, this.getCountOfEggsPerMonth());
    }
}
