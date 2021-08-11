package javarush.task.task36.task3608;

import javarush.task.task36.task3608.controller.Controller;
import javarush.task.task36.task3608.model.MainModel;
import javarush.task.task36.task3608.model.Model;
import javarush.task.task36.task3608.view.EditUserView;
import javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Smirnov", 126L, 1);
        usersView.fireEventShowDeletedUsers();
    }
}