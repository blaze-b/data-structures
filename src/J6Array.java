public class J6Array {
    public static void main(String[] args) {

        //By Specifying the size
        int a[] = new int[10];

        a[0] = 10;//initialization
        a[1] = 20;
        a[2] = 70;
        a[3] = 40;
        a[4] = 50;

        //traversing array
        for (int i = 0; i < a.length; i++)//length is the property of array
            System.out.println(a[i]);


        //By initializing
        int[] b = new int[]{23, 13, 123, 123};
        for (int i = 0; i < b.length; i++)
            System.out.println(b[i]);
    }
}
