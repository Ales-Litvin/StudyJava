package learn.main;

public class Clone implements Cloneable, Comparable<Clone>{
    public static void main(String[] args) throws CloneNotSupportedException {
        Clone clone = new Clone("Clone 1", 2);
        Clone clone1 = (Clone) clone.clone();

        System.out.println(clone);
        System.out.println(clone1);
    }


    private String name;
    private int age;

    public Clone(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clone{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clone)) return false;

        Clone clone = (Clone) o;

        if (age != clone.age) return false;
        return name != null ? name.equals(clone.name) : clone.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Clone o) {
        return this.name.compareTo(o.name);
    }
}
