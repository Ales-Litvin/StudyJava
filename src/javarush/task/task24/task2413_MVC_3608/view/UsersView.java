package javarush.task.task24.task2413_MVC_3608.view;

import javarush.task.task24.task2413_MVC_3608.bean.User;
import javarush.task.task24.task2413_MVC_3608.controller.Controller;
import javarush.task.task24.task2413_MVC_3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;


    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) System.out.println("All deleted users:");
        else System.out.println("All users:");
        for (User user: modelData.getUsers()){
            System.out.println("\t" + user.toString());
        }
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

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
