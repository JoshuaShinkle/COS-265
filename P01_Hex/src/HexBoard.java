/****************************************************************************
 *  This class manages an N-by-N hex game board .
 ****************************************************************************/

public class HexBoard {
    private int[] board;
    private WeightedQuickUnionUF uf1;
    private WeightedQuickUnionUF uf2;
    private WeightedQuickUnionUF uf3;
    private int N;

    public HexBoard(int N) {
        if (N <= 0) {throw new java.lang.IllegalArgumentException("N cannot be <= 0");}
        board = new int[N*N+4];
        board[N*N+0] = 1;
        board[N*N+1] = 2;
        board[N*N+2] = 1;
        board[N*N+3] = 2;
        uf1 = new WeightedQuickUnionUF(N*N+4);
        uf2 = new WeightedQuickUnionUF(N*N+4);
        uf3 = new WeightedQuickUnionUF(N*N+4);
        this.N = N;
    }

    public int getPlayer(int row, int col) {
        if (!isValidHex(row, col)) { throw new java.lang.IndexOutOfBoundsException("row or col is out of range"); }
        return this.board[toIndex(row,col)];
    }
    
    public boolean isSet(int row, int col) {
        if (!isValidHex(row, col)) { throw new java.lang.IndexOutOfBoundsException("row or col is out of range"); }
        if (this.board[toIndex(row, col)] == 0) { return false; }
        return true;
    }

    public boolean isOnWinningPath(int row, int col) {
        if (!isValidHex(row, col)) { throw new java.lang.IndexOutOfBoundsException("row or col is out of range"); }
        if ((uf2.connected(N*N+0, toIndex(row, col)) && uf3.connected(N*N+2, toIndex(row, col))) || (uf2.connected(N*N+1, toIndex(row, col)) && uf3.connected(N*N+3, toIndex(row, col)))) { return true; }
        return false;
    }

    public void setTile(int row, int col, int player) {
        if (!isValidHex(row, col)) { throw new java.lang.IndexOutOfBoundsException("row or col is out of range"); }
        if (this.isSet(row,col)) { throw new java.lang.IllegalArgumentException("Tile is already set"); }
        this.board[toIndex(row,col)] = player;
        if (isValidHex(row+1,col) && this.board[toIndex(row+1,col)] == player) {
            uf1.union(toIndex(row,col), toIndex(row+1,col));
            uf2.union(toIndex(row,col), toIndex(row+1,col));
            uf3.union(toIndex(row,col), toIndex(row+1,col));
        }
        if (isValidHex(row-1,col) && this.board[toIndex(row-1,col)] == player) {
            uf1.union(toIndex(row,col), toIndex(row-1,col));
            uf2.union(toIndex(row,col), toIndex(row-1,col));
            uf3.union(toIndex(row,col), toIndex(row-1,col));
        }
        if (isValidHex(row,col+1) && this.board[toIndex(row,col+1)] == player) {
            uf1.union(toIndex(row,col), toIndex(row,col+1));
            uf2.union(toIndex(row,col), toIndex(row,col+1));
            uf3.union(toIndex(row,col), toIndex(row,col+1));
        }
        if (isValidHex(row,col-1) && this.board[toIndex(row,col-1)] == player) {
            uf1.union(toIndex(row,col), toIndex(row,col-1));
            uf2.union(toIndex(row,col), toIndex(row,col-1));
            uf3.union(toIndex(row,col), toIndex(row,col-1));
        }
        if (isValidHex(row+1,col-1) && this.board[toIndex(row+1,col-1)] == player) {
            uf1.union(toIndex(row,col), toIndex(row+1,col-1));
            uf2.union(toIndex(row,col), toIndex(row+1,col-1));
            uf3.union(toIndex(row,col), toIndex(row+1,col-1));
        }
        if (isValidHex(row-1,col+1) && this.board[toIndex(row-1,col+1)] == player) {
            uf1.union(toIndex(row,col), toIndex(row-1,col+1));
            uf2.union(toIndex(row,col), toIndex(row-1,col+1));
            uf3.union(toIndex(row,col), toIndex(row-1,col+1));
        }
        if (player == 1) {
            if (col == 0) {
                uf1.union(toIndex(row, col),N*N+0);
                uf2.union(toIndex(row, col),N*N+0);
            } else if (col == N-1) {
                uf1.union(toIndex(row, col), N*N+2);
                uf3.union(toIndex(row, col), N*N+2);
            }
        } else if (player == 2) {
            if (row == 0) {
                uf1.union(toIndex(row, col), N*N+3);
                uf3.union(toIndex(row, col), N*N+3);
            } else if (row == N-1) {
                uf1.union(toIndex(row, col), N*N+1);
                uf2.union(toIndex(row, col), N*N+1);
            }
        }
    }

    public boolean hasPlayer1Won() {
        if (!uf1.connected(N*N+0, N*N+2)) { return false; }
        return true;
    }

    public boolean hasPlayer2Won() {
        if (!uf1.connected(N*N+1, N*N+3)) { return false; }
        return true;
    }

    public int numberOfUnsetTiles() {
        int count = 0;
        for (int row=0; row<N; row++) {
            for (int col=0; col<N; col++) {
                if (!this.isSet(row, col)) {count++;}
            }
        }
        return count;
    }

    private int toIndex(int row, int col) {
        if (!isValidHex(row, col)) { throw new java.lang.IndexOutOfBoundsException("row or col is out of range"); }
        return (row * N) + col;
    }

    private boolean isValidHex(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) { return false; }
        return true;
    }
}
