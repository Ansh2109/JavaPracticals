

public class Driver {
    public static void main(String []args){
        Point[] point={new Point(1,2),new Point(3,4),new Point(5,6),new Point(3,4)};

        int distinctcount = 0;
        for (int i = 0; i < point.length; i++) {
            boolean seenBefore = false;
            for (int j = 0; j < i; j++) {
                if (point[i].equals(point[j])) {
                    seenBefore = true;
                    break;
                }
            }
            if (!seenBefore) distinctcount++;
        }

        System.out.println("Distinct:" + distinctcount);
    }
}
