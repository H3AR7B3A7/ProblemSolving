package be.dog.d.steven.cartesianCoordinates;

public class Coords {
    private int x;
    private int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * GET THE MINIMUM AMOUNT OF STEPS BETWEEN TWO COORDINATES WHEN EITHER OR BOTH CAN BE INCREMENTED
     * OR DECREMENTED BY ONE EACH STEP (MOVING VERTICALLY, HORIZONTALLY OR DIAGONALLY)
     *
     * @param first  One of two sets of coordinates
     * @param second The Second of two sets of coordinates
     * @return Minimum steps between two given coordinates
     */
    public static int shortestPathBetweenCoords(Coords first, Coords second) {
        int deltaX = Math.abs(first.x - second.x);
        int deltaY = Math.abs(first.y - second.y);
        return Math.max(deltaX, deltaY);
    }

    public static int shortestPathCoveringMultipleCoords(Coords[] arrayOfCoords) {
        int steps = 0;
        for (int i = 0; i < arrayOfCoords.length - 1; i++) {
            steps += shortestPathBetweenCoords(arrayOfCoords[i], arrayOfCoords[i + 1]);
        }
        return steps;
    }
}
