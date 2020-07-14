package javarush.task.task30.lessons.nullPointerException;

class Data {
    public static void main(String[] args) {
        System.out.println(1.0 / 0.0);
    }

    private String val;

    public Data(String val) {
        this.val = val;
    }

    public String getValue() {
        return val;
    }


    static class Formatter {
        public static String format(String value) {
            return value.trim();
        }
    }

    public static class TestNPE {
        public static String handle(Formatter f, Data d) {
            return f.format(d.getValue());
        }
    }
}