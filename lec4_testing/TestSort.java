package lec4_testing;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestSort {

    // someone else's main method iterates over all methods in TestSort
    // that have this little @Test method attached to it
    // then compiles all the results
    // then IntelliJ reads them and it looks nice
    @Test
    public void testSort() {
        String[] input = {"velociraptor", "arradium", "horse", "koshi"};
        String[] expected = {"arradium", "horse", "koshi", "velociraptor"};

        Sort.sort(input);
        assertThat(input).isEqualTo(expected);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"velociraptor", "arradium", "horse", "koshi"};
        int expectedSmallest = 2;
        int actualSmallest = Sort.findSmallest(input, 2);

        assertThat(actualSmallest).isEqualTo(expectedSmallest);
    }

    @Test
    public void testSwap() {
        String[] input = {"velociraptor", "arradium", "horse", "koshi"};
        Sort.swap(input, 0, 1);

        String[] expected = {"arradium", "velociraptor", "horse", "koshi"};
        assertThat(expected).isEqualTo(input);
    }
}
