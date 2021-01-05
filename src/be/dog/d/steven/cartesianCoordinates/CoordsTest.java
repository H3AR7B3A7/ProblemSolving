package be.dog.d.steven.cartesianCoordinates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordsTest {

    @Test
    void shortest_path_between_two_coords_test() {
        Coords first = new Coords(0, 0);
        Coords second = new Coords(3, -4);
        assertEquals(4, Coords.shortestPathBetweenCoords(first, second));
    }

    @Test
    void shortest_path_between_multiple_coords_test() {
        Coords[] arrayOfCoords = new Coords[]{new Coords(0, 0), new Coords(5, 4), new Coords(-3, 2)};
        assertEquals(13, Coords.shortestPathCoveringMultipleCoords(arrayOfCoords));
    }

}