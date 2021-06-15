package General;

public class Generate_Class_Names {

    public static void main(String[] args) {
        String s = "Implement strStr";
        s = s.trim().replaceAll(" ", "_");
        System.out.println(s);
    }

}
