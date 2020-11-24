package javarush.task.task34.task3410.view;

import javarush.task.task34.task3410.controller.EventListener;
import javarush.task.task34.task3410.model.Box;
import javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
    }

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public void paint(Graphics graphics){
        new Player(4, 5).draw(graphics);
        new Box(4,5 ).draw(graphics);
    }
}
