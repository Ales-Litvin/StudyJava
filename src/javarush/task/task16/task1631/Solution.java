package javarush.task.task16.task1631;

// нету com.
import javarush.task.task16.task1631.common.ImageReader;
import javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
}
