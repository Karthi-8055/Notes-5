import java.util.*;

class BellmanFord {
    static final int INF = 999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of vertices: ");
        int n = sc.nextInt();
        int A[][] = new int[n + 1][n + 1];
        int D[] = new int[n + 1];

        System.out.println("Enter adjacency matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                A[i][j] = sc.nextInt();

                if (i == j)
                    A[i][j] = 0;
                else if (A[i][j] == 0)
                    A[i][j] = INF;
            }
        }

        System.out.print("Enter source vertex: ");
        int s = sc.nextInt();

        Arrays.fill(D, INF);
        D[s] = 0;

        // Relax edges (n - 1) times
        for (int k = 1; k < n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (A[i][j] != INF && D[j] > D[i] + A[i][j])
                        D[j] = D[i] + A[i][j];
                }
            }
        }

        // Check for negative weight cycle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i][j] != INF && D[j] > D[i] + A[i][j])
                    System.out.println("Negative edge cycle!");
            }
        }

        // Print shortest distances
        for (int i = 1; i <= n; i++) {
            System.out.println("Dist from " + s + " to " + i + " = " + D[i]);
        }

        sc.close();
    }
}
