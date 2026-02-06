package lec8_lists4;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class AListTest {
    @Test
    public void add2000Items() {
        AList list = new AList();
        for (int i = 0; i < 2000; i += 1) {
            list.addLast(i);
        }

        for (int i = 0; i < 2000; i += 1) {
            assertThat(list.get(i)).isEqualTo(i);
        }
    }
}