class ArrayProd {

    static int mul(int[] c) {
        if (c == null) {
            throw new NullPointerException();
        }
        int countSum = 1;
        for (int i : c) {
            countSum *= i;
        }
        return countSum;
    }
}
