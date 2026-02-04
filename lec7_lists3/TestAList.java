package lec7_lists3;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestAList {
    @Test
    public void testAList() {
        AList myList = new AList();
        assertThat(myList.size()).isEqualTo(0);

        myList.addLast(4);
        myList.addLast(10);

        assertThat(myList.get(0)).isEqualTo(4);
        assertThat(myList.get(1)).isEqualTo(10);

        assertThat(myList.removeLast()).isEqualTo(10);
        assertThat(myList.size()).isEqualTo(1);

        // Wait was it really OK that we didn't zero out that item? Let's try...
        myList.addLast(22);
        assertThat(myList.get(1)).isEqualTo(22);
    }
}
