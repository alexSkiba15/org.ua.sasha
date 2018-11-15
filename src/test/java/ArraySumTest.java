import alex.ArraySum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraySumTest {
    private static int mas[] = {4,1,5,1,6,1,7,8,4};
    private static int sum = 37;
    private ArraySum arraySum;

    @Before
    public void createArraySum(){
        arraySum = new ArraySum(mas);
    }

    @Test
    public void sumArrayStatical()  {
        int expected = sum;
        int actual = arraySum.sum(mas);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sumArray() {
        int expected = sum;
        int actual = arraySum.sum();
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = NullPointerException.class)
    public void checkNull()throws Exception{
        int actual = arraySum.sum(null);
        Assert.assertNull(actual);
    }
}