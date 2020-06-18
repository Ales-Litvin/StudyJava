package javarush.task.task24.task2413_MVC_3608;

import javarush.task.task24.task2413_MVC_3608.controller.Controller;
import javarush.task.task24.task2413_MVC_3608.model.MainModel;
import javarush.task.task24.task2413_MVC_3608.model.Model;
import javarush.task.task24.task2413_MVC_3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        usersView.fireEventShowDeletedUsers();
    }
}