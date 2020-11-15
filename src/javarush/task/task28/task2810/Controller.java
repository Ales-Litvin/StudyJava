package javarush.task.task28.task2810;

import javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0){
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Controller{");
        sb.append("providers=").append(Arrays.toString(providers));
        sb.append('}');
        return sb.toString();
    }
}
