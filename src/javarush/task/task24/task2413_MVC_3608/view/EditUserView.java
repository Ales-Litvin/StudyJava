package javarush.task.task24.task2413_MVC_3608.view;

import javarush.task.task24.task2413_MVC_3608.controller.Controller;
import javarush.task.task24.task2413_MVC_3608.model.ModelData;

public class EditUserView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser().toString());
        System.out.println("===================================================");

    }


    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void fireEventShowDeletedUsers(){
        controller.onShowAllDeletedUsers();
    }
}
