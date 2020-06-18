package javarush.task.task24.task2413_MVC_3608.view;

import javarush.task.task24.task2413_MVC_3608.controller.Controller;
import javarush.task.task24.task2413_MVC_3608.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
    void fireEventShowDeletedUsers();
}
