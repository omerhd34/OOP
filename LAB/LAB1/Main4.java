package LAB.LAB1;
public class Main4 {
    public static void main(String[] args) {
        int score = 100;
        // byte, short, int, or char.
        switch (score) {
            case 100:
            case 90:
                System.out.println("Very good.");
                break;
            case 60:
                System.out.println("Good");
                break;
            case 40:
                System.out.println("OK");
                break;
            default:
                System.out.println("The grades are not defined");
        }
    }
}
// Very good.