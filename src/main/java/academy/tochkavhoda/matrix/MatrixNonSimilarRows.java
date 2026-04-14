package academy.tochkavhoda.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MatrixNonSimilarRows {
    private final int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Set<Set<Integer>> seenSignatures = new HashSet<>();
        Set<int[]> result = new LinkedHashSet<>();
        for (int[] row : matrix) {
            Set<Integer> signature = new HashSet<>();
            Arrays.stream(row).forEach(signature::add);
            if (seenSignatures.add(signature)) {
                result.add(row);
            }
        }
        return result;
    }
}
