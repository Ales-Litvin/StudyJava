package by.epam.learn.multithread.rwlock;

public class PointThread extends Thread{
    private final PointManager pointManager;
    private final boolean writeStatus;
    private final Point point;

    public PointThread(PointManager pointManager, Point point, boolean writeStatus) {
        this.pointManager = pointManager;
        this.point = point;
        this.writeStatus = writeStatus;
    }

    @Override
    public void run() {
        if (writeStatus){
            pointManager.randomChangePoint(point);
        } else {
            pointManager.length(point);
        }
    }
}
