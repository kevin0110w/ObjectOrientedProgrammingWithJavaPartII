
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {       
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        
        for (int i = 0; i < t.length; i++) {
            // if 4 elements have been appended, add a new line
            if (i % 4 == 0) {
                builder.append("\n");
            }
            // otherwise append the element
            builder.append(" " + t[i]);
            
            // append a comma after each element is added except the last one.
            if (i != t.length - 1) {
                builder.append(",");
            }
        }
        builder.append("\n");
        builder.append("}");
        return builder.toString();
    }
}
