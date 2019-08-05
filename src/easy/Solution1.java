package cat;

public class Cat1 {
    public int aplusb(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args){
        Cat1 cat1 = new Cat1();
        System.out.println(3^4);
    }
}