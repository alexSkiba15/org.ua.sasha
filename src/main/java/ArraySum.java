class ArraySum {

    private static int[] number;

    void setNumber(int[] number) {
        ArraySum.number = number;
    }

    ArraySum(int[] number) {
        setNumber(number);
    }

    static int sum(int[] c) {
        if (c == null) {
            throw new NullPointerException();
        }
        int countSum = 0;
        for (int i : c) {
            countSum += i;
        }
        return countSum;
    }

    int sum() {
        int countSum = 0;
        for (int i : number) {
            countSum += i;
        }
        return countSum;
    }
}
