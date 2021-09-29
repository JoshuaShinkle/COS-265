/****************************************************************************
 *  Command: HexBoardStats N0 N1 T
 *
 *  This program takes the board sizes N0,N1 and game count T as a command-line
 *  arguments. Then, the program runs T games for each board size N where
 *  N0 <= N <= N1 and where each play randomly chooses an unset tile to set in
 *  order to estimate the probability that player 1 will win.
 ****************************************************************************/

public class HexBoardStats {
    private int N0 = -1;
    private int N1 = -1;
    private int T = -1;
    private double prob[];
    public HexBoardStats(int N0, int N1, int T) {
        if (N0 <= 0 || N1 < N0 || T <= 0) { throw new java.lang.IllegalArgumentException("Illegal Argument(s)"); }
        this.N0 = N0;
        this.N1 = N1;
        this.T = T;
        this.prob = new double[N1-N0+1];
        for (int i=N0; i<=N1; i++) {
            Stopwatch runtime = new Stopwatch();
            for (int j=0; j<T; j++) {
                prob[i-N0] += playAGame(i) == 1 ? 1:0;
            }
            prob[i-N0] = prob[i-N0]/T;
            StdOut.println("elapsed time for " + i + ": " + runtime.elapsedTime());
        }
    }

    public int getN0() { return this.N0; }

    public int getN1() { return this.N1; }

    public int getT() { return this.T; }

    public double getP1WinProbabilityEstimate(int n) {
        if (n < N0 || n > N1) { throw new java.lang.IndexOutOfBoundsException(""); }
        return this.prob[n-N0];
    }

    public double getP2WinProbabilityEstimate(int n) {
        return 1.0 - getP1WinProbabilityEstimate(n);
    }

    private static int playAGame(int N) {
        HexBoard board = new HexBoard(N);
        int player = 1;
        while(!board.hasPlayer1Won() && !board.hasPlayer2Won()) {
            int row = StdRandom.uniform(N);
            int col = StdRandom.uniform(N);
            if (board.isSet(row, col)) { continue; }
            board.setTile(row, col, player);
            player = player == 1 ? 2:1;
        }
        return board.hasPlayer1Won() ? 1:0;
    }

    private void printReport() {
        StdOut.println("T = " + T);
        for (int N=N0; N<=N1; N++) {
            StdOut.print("N = " + N + " ");
            StdOut.print("P1 = " + getP1WinProbabilityEstimate(N) + " ");
            StdOut.print("(" + getP1WinProbabilityEstimate(N)*T + ")" + " ");
            StdOut.print("P2 = " + getP2WinProbabilityEstimate(N) + " ");
            StdOut.print("(" + getP2WinProbabilityEstimate(N)*T + ")" + " ");
            StdOut.println("");
        }
    }

    public static void main(String[] args) {
        int N0 = Integer.parseInt(args[0]);
        int N1 = Integer.parseInt(args[1]);
        int T = Integer.parseInt(args[2]);
        HexBoardStats hbs = new HexBoardStats(2,15,100000);
        hbs.printReport();
    }
}