import java.lang.IndexOutOfBoundsException;
import java.lang.IllegalArgumentException;

/**
 * Pathfinder uses A* search to find a near optimal path
 * between to locations with given terrain.
 */

public class Pathfinder {

    /**
     * PFNode will be the key for MinPQ (used in computePath())
     */
    private class PFNode implements Comparable<PFNode> {
        // loc: the location of the PFNode
        // fromNode: how did we get here? (linked list back to start)
        public PFNode(Coord loc, PFNode fromNode) { }

        // compares this with that, used to find minimum cost PFNode
        public int compareTo(PFNode that) {
            return 0;
        }

        // returns the cost to travel from starting point to this
        // via the fromNode chain
        public float getCost(float heuristic) {
            return 0;
        }

        // returns if this PFNode is still valid
        public boolean isValid() {
            return false;
        }

        // invalidates the PFNode
        public void invalidate() {
        }

        // returns if the PFNode has been used
        public boolean isUsed() {
            return true;
        }

        // uses the PFNode
        public void use() { }

        // returns an Iterable of PFNodes that surround this
        public Iterable<PFNode> neighbors() {
            Stack<PFNode> s = new Stack<>();
            s.push(new PFNode(null, null));
            return s;
        }
    }

    public Pathfinder(Terrain terrain) {
    }

    public void setPathStart(Coord loc) {
    }

    public Coord getPathStart() {
        return null;
    }

    public void setPathEnd(Coord loc) {
    }

    public Coord getPathEnd() {
        return null;
    }

    public void setHeuristic(float v) {
    }

    public float getHeuristic() {
        return 0;
    }

    public void resetPath() {
    }

    public void computePath() {
    }

    public boolean foundPath() {
        return false;
    }

    public float getPathCost() {
        return 0;
    }

    public int getSearchSize() {
        return 0;
    }

    public Iterable<Coord> getPathSolution() {
        return null;
    }

    public boolean wasSearched(Coord loc) {
        return false;
    }
}
