package javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country {
    public int getCountOfEggsPerMonth(){
        return 3;
    }
    @Override
    public String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.",
                MOLDOVA, this.getCountOfEggsPerMonth());
    }
}
