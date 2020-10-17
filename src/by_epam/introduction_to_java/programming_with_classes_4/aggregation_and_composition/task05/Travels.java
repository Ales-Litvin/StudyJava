package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task05;
/*
 * 5. Туристические путевки.
 *    Сформировать набор предложений клиенту по выбору туристической путевки различного типа
 *    (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
 *    Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Travels {
    private List<Travel> travels;

    public Travels(List<Travel> travels) { this.travels = travels; }

    public Travels() { this.travels = new ArrayList<>(); }

    public void add(Travel travel){ travels.add(travel); }

    /**
     * Returns the best travel for client.
     * @return the best travel for client.
     */
    public Travel getBetter(Travel travel){
        sort(travel);
        return travels.get(0);
    }

    public List<Travel> getTravels() { return travels; }

    public void setTravels(List<Travel> travels) { this.travels = travels; }

    @Override
    public String toString() {
        return "Travels: " + travels + ';';
    }

    public void sort(Travel travel){
        this.travels.sort(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
                int one = o1.getType() == travel.getType() ? 0 : -1;
                int two = o2.getType() == travel.getType() ? 0 : -1;
                return Integer.compare(two, one);
            }
        }.thenComparing(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
                int one = Integer.compare(o1.getDays(), travel.getDays());
                int two = Integer.compare(o2.getDays(), travel.getDays());
                return Integer.compare(one, two);
            }
        }.thenComparing(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
                int one = o1.getTransport() == travel.getTransport()  ? 0 : -1;
                int two = o2.getTransport() == travel.getTransport()  ? 0 : -1;
                return Integer.compare(two, one);
            }
        }.thenComparing(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
                int one = o1.getFood() == travel.getFood()  ? 0 : -1;
                int two = o2.getFood() == travel.getFood()  ? 0 : -1;
                return Integer.compare(two, one);
            }
        }))));
    }
}
