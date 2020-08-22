package javarush.task.task34.task3404;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        String s;
        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);
        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0); s = "tan(-45)";
        System.out.print(s + " expected output -1 2 actually ");
        solution.recursion(s, 0);
        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);
        s = "0.3051"; System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0); s = "(0.3051)";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0); s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0); s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0); s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0); s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0); s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);
        s = "10-2^(2-1+1)";
        System.out.print(s + " expected output 6 4 actually ");
        solution.recursion(s, 0);
        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);
        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0); s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);
        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0); s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);
        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);
        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);
        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);
        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
    }

    public void recurse(final String expression, int countOperation) {
        //implement
    }

    public static void recursion(final String expression, int countOperation) {
        //implement
    }

    public Solution() {
        //don't delete
    }
}
