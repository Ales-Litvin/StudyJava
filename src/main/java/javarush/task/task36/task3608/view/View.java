package javarush.task.task36.task3608.view;

import javarush.task.task36.task3608.controller.Controller;
import javarush.task.task36.task3608.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}