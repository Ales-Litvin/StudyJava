package javarush.task.task31.task3110;

/**
 * Класс отвечающий за свойсва кждого файла в архиве
 * Свойства - это набор, состоящий из: имя файл, размер файла до и после сжатия, метод сжатия
 * (который хранитьс на диске и имеет расширение .zip).
 * @autor Aleksandr
 * @version 0.1
 */
public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    // getters
    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public long getCompressionRatio(){
        return 100 - ((compressedSize * 100) / size);
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    @Override
    public String toString() {
        if (size > 0)
            return String.format("%s %d Kb (%d Kb) сжатие: %d%%",
                    name, size/1024, compressedSize/1024, getCompressionRatio());
        else return name;
    }
}