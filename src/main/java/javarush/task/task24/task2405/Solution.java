package javarush.task.task24.task2405;

/*
 * 1. Восстанови логику метода someAction для поля solutionAction.
 * 2. Пример вывода смотри в комментарии к методу learn.main.
 * 3. Подсказка: метод someAction анонимного класса поля
 * SolutionAction должен вызвать метод сабкласса FirstClass,
 * если param > 0, иначе вызвать метод сабкласса SecondClass.
 *
 * Не изменяй метод learn.main!
 */


/*
Black box
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private final Action solutionAction = new Action() {
        //напишите тут ваш код

        public void someAction() {
            //напишите тут ваш код
            if (param > 0) {
                while (param > 0) {
                    System.out.println(param);
                    param--;
                }
                FirstClass firstClass = new FirstClass() {

                    @Override
                    public Action getDependantAction() {
                        return this;
                    }
                };
                firstClass.getDependantAction().someAction();

            }
            if (param <= 0) {
                SecondClass secondClass = new SecondClass() {

                    @Override
                    public void someAction() {
                        this.sb.append(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM
                                + param);
                        super.someAction();
                    }
                };
                secondClass.someAction();
            }
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}