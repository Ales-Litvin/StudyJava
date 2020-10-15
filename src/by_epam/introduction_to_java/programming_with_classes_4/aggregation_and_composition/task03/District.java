package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task03;

// Район
public class District {
    private City districtCenter;

    private final double area;

    public District(City districtCenter, double area) {
        this.districtCenter = districtCenter;
        this.area = area;
    }

    public double getArea() { return area; }

    public City getDistrictCenter() { return districtCenter; }

    public void setDistrictCenter(City districtCenter) { this.districtCenter = districtCenter; }
}
