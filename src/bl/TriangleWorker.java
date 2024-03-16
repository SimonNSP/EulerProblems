package bl;

import beans.Triangle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class TriangleWorker implements Callable<Set<int[]>> {

    private final int scope;

    public TriangleWorker(int scope) {
        this.scope = scope;
    }

    @Override
    public Set<int[]> call() throws Exception {
        Set<int[]> triangles = new HashSet<>();
        int k;

        for (int i = 3; i < scope; i++) {
            for (int j = i+1; j < (scope-i)/2; j++) {
                k = scope - i - j;
                Triangle triangle = new Triangle(new int[]{i, j, k, scope}, scope);
                if (triangle.isRightTriangle() && triangle.hasCorrectScope()) {
                    triangles.add(triangle.getSides());
                }
            }
        }
        return triangles;
    }
}
