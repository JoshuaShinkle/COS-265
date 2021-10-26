import java.util.Iterator;

/**
 * Walker takes an Iterable of Coords and simulates an individual
 * walking along the path over the given Terrain
 */
public class Walker {

    // terrain: the Terrain the Walker traverses
    // path: the sequence of Coords the Walker follows
    public Walker(Terrain terrain, Iterable<Coord> path) {
    }

    // returns the Walker's current location
    public Coord getLocation() {
        return null;
    }

    // returns true if Walker has reached the end Coord (last in path)
    public boolean doneWalking() {
        return true;
    }

    // advances the Walker along path
    // byTime: how long the Walker should traverse (may be any non-negative value)
    public void advance(float byTime) {
    }

}
