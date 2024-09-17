package ukgTest;

public class TwoOperationsRedux {

    public static int maximizeX(int x, int y, int z) {
        int requiredOps = Math.abs(y - x);
        if (z > requiredOps) {
            int remainingOps = z - requiredOps;
            return Math.max(x, y) + remainingOps / 2;
        } else {
            return Math.max(x, y);
        }
    }
    public static int maximizeXe(int x, int y, int z) {
        int requiredOps = Math.abs(y - x);

        if (z >= requiredOps) {
            int remainingOps = z - requiredOps;
            return Math.max(x, y) + remainingOps / 2;
        } else {
//            return Math.max(x, y);
            return x+z;
//            return -1;// if asked
        }
    }

    public static void main(String[] args) {
        int x = 659076, y = 759012, z = 15;
        int result = maximizeXe(x, y, z);
        System.out.println("The maximum achievable value of x is: " + result);

    }
}
