package alex;

public class ArraySum {

    private static int[] number;

    void setNumber(int[] number) {
        ArraySum.number = number;
    }

    public ArraySum(int[] number) {
        setNumber(number);
    }

    public static int sum(int[] c) {
        if (c == null) {
            throw new NullPointerException();
        }
        int countSum = 0;
        for (int i : c) {
            countSum += i;
        }
        return countSum;
    }

    public int sum() {
        int countSum = 0;
        for (int i : number) {
            countSum += i;
        }
        return countSum;
    }
}
