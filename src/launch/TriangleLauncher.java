package launch;

import bl.TriangleWorker;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class TriangleLauncher {
    public void runWorkers() {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        ExecutorCompletionService<Set<int[]>> service = new ExecutorCompletionService<>(pool);

        for (int i = 3; i < 10000; i++) {
            service.submit(new TriangleWorker(i));
        }

        pool.shutdown();
        int maxSolutions = 0;
        int maxSolutionAt = 0;
        Set<int[]> maxSolution = new HashSet<>();
        for (int i = 3; i < 10000; i++) {
            try {
                Future<Set<int[]>> future = service.take();
                if (future.get().size() > maxSolutions) {
                    maxSolutions = future.get().size();
                    maxSolution = future.get();
                    // maxSolutionAt = i; // wrong
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        for (int[] nums : maxSolution) {
            maxSolutionAt = nums[3];
        }

        System.out.println("Max Solutions (" + maxSolutions + ") with scope: " + maxSolutionAt);
        for (int[] nums : maxSolution) {
            System.out.println(nums[0] + ", " + nums[1] + ", " + nums[2]);
        }
    }

    public static void main(String[] args) {
        new TriangleLauncher().runWorkers();
    }
}
