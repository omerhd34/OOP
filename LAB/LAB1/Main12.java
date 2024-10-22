package LAB.LAB1;

public class Main12
{
    public static void main( String[] args )
    {
        int[] myintarray = {100, 31, 26, 48, 52};
        int index = 0;
        while (index < 5) {
            System.out.println(myintarray[index]);
            index++;
        }
        int[] myIntArray = new int[3];
        for (int i = 0; i < myIntArray.length; i++) {
            System.out.println("myIntArray[" + i + "] = " + myIntArray[i]);
        }
    }
}
/*
100
31
26
48
52
myIntArray[0] = 0
myIntArray[1] = 0
myIntArray[2] = 0
 */
