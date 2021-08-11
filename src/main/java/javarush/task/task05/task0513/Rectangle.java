package javarush.task.task05.task0513;

public class Rectangle {
    // напишите тут ваш код
    int top;    // верхняя координата
    int left;   // левая координата
    int width;   // ширина
    int height;  // высота

    public void initialize(int left, int top, int width, int height){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void initialize(int left, int top){
        this.left = left;
        this.top = top;
        this.height = 0;
        this.width = 0;
    }

    public void initialize(int left, int top, int width){
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = 0;
    }

    public void initialize(int top){
        this.left = 0;
        this.top = top;
        this.width = 0;
        this.height = 0;
    }

    public static void main(String[] args) {

    }
}
