import alex.ArrayProd;
import org.junit.Assert;
import org.junit.Test;

public class ArrayProdTest {

    @Test
    public void mul() {
        int[] mas = {3,5,2,5};
        int mul = 150;
        int actual = ArrayProd.mul(mas);
        Assert.assertEquals(mul,actual);
    }

    @Test(expected = NullPointerException.class)
    public void mulNull() {
        int actual = ArrayProd.mul(null);
        Assert.assertNull(actual);
    }
}