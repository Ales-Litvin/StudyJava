package by.epam.learn.multithread.rwlock;

public class PointThread extends Thread{
    private PointManager pointManager;
    private boolean writeStatus;
    private Point point;

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
