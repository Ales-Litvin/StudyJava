package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task03;

import java.util.List;

// Область
public class Region {
    private City regionalCenter;

    private List<District> districts;

    private double area;

    public Region(City regionalCenter, List<District> districts) {
        this.regionalCenter = regionalCenter;
        this.districts = districts;
        this.area = initialArea();
    }

    /**
     * Counting of area of districts
     * @return area of districts
     */
    public long initialArea(){
        long result = 0L;
        for (District district : districts){
            result += district.getArea();
        }
        return result;
    }

    public double getArea() { return area; }

    public City getRegionalCenter() { return regionalCenter; }

    public void setRegionalCenter(City regionalCenter) { this.regionalCenter = regionalCenter; }

    public List<District> getDistricts() { return districts; }

    public void setDistricts(List<District> districts) { this.districts = districts; }
}
