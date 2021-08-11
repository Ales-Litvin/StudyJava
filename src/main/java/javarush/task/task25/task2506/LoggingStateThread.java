package javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;
    private State state;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.state = thread.getState();
        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(state.name());
        while (isInterrupted()){
            if (!state.equals(state = thread.getState())){
                System.out.println(state.name());
            }
            if (state.equals(State.TERMINATED)){
                break;
            }
        }
    }
}