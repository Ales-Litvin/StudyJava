package javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country{
    public int getCountOfEggsPerMonth(){
        return 4;
    }

    @Override
    public String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                BELARUS, this.getCountOfEggsPerMonth());
    }
}
