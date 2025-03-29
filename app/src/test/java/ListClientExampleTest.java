import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import oreillydatastructure.ListClientExample;

public class ListClientExampleTest {

    @Test
    public void testListClientExample() {
        ListClientExample lce = new ListClientExample();
        @SuppressWarnings("rawtypes")
        List list = lce.getList();
        Assertions.assertInstanceOf(ArrayList.class, list);
    }

}
