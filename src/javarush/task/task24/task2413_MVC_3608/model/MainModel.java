package javarush.task.task24.task2413_MVC_3608.model;

import javarush.task.task24.task2413_MVC_3608.bean.User;
import javarush.task.task24.task2413_MVC_3608.model.service.UserService;
import javarush.task.task24.task2413_MVC_3608.model.service.UserServiceImpl;

public class MainModel implements Model{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;

    }

    @Override
    public void loadUsers() {
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setUsers(userService.getAllDeletedUsers());
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
}
