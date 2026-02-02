package lec6_lists2;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestSLList {
    @Test
    public void testSLList() {
        SLList myList = new SLList();
        myList.addLast(17);

        assertThat(myList.size()).isEqualTo(1);
        assertThat(myList.get(0)).isEqualTo(17);
    }
}