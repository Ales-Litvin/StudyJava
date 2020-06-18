package javarush.task.task16.task1631;

import javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes typ) throws IllegalArgumentException {
        ImageReader reader = null;

        if (ImageTypes.JPG.equals(typ)) {
            reader = new JpgReader();
        } else if (ImageTypes.BMP.equals(typ)) {
            reader = new BmpReader();
        } else if (ImageTypes.PNG.equals(typ)) {
            reader = new PngReader();
        }
        else {
            throw new IllegalArgumentException();
        }

        return reader;
    }
}
