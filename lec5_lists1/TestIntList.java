package lec5_lists1;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestIntList {
    @Test
    public void testIntList() {
        IntList l1 = new IntList(5, new IntList(10, new IntList(15, null)));

        assertThat(l1.size()).isEqualTo(3);

        assertThat(l1.getIterative(0)).isEqualTo(5);
        assertThat(l1.getIterative(1)).isEqualTo(10);

        IntList incremented = l1.incrementRecursiveNonDestructive();

        // Make sure incremented has ints that have all been incremented by 1.
        assertThat(incremented.get(0)).isEqualTo(6);
        assertThat(incremented.get(1)).isEqualTo(11);
        assertThat(incremented.get(2)).isEqualTo(16);
        assertThat(incremented.size()).isEqualTo(3);

        // Make sure incrementRecursiveNonDestructive was indeed non-destructive
        assertThat(l1.get(0)).isEqualTo(5);
    }
}
