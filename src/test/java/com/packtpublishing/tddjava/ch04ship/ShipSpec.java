package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    private Ship ship;
    private Location location;
    private Planet planet;

    @BeforeMethod
    public void beforeTest() {
        Point max = new Point(50, 50);
        location = new Location(new Point(11, 41), Direction.NORTH);
        planet = new Planet(max, getObstacleList());
        ship = new Ship(location, planet);
    }

    public void whenInstantiatedThenLocationIsSet() {
        assertEquals(ship.getLocation(), location);
    }

    public void givingNorthWhenMoveForwardThenYDecrease() {
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(), 40);
    }

    public void givingEastWhenMoveForwardThenXIncrease() {
        ship.getLocation().setDirection(Direction.EAST);
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getX() ,12);
    }

    public void whenMoveForwardThenForward() {
        Location expectedLocation = location.copy();
        expectedLocation.forward();
        ship.moveForward();
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenMoveBackwardThenBackward() {
        Location expectedLocation = location.copy();
        expectedLocation.backward();
        ship.moveBackward();
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenTurnLeftThenLeft() {
        Location expectedLocation = location.copy();
        expectedLocation.turnLeft();
        ship.turnLeft();
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenTurnLeftThenRight() {
        Location expectedLocation = location.copy();
        expectedLocation.turnRight();
        ship.turnRight();
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenReceiveCommandWithLThenLeft() {
        Location expectedLocation = location.copy();
        expectedLocation.turnLeft();
        ship.executeCommands("l");
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenReceiveCommandWithRThenRight() {
        Location expectedLocation = location.copy();
        expectedLocation.turnRight();
        ship.executeCommands("r");
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenReceiveCommandWithFThenForward() {
        Location expectedLocation = location.copy();
        expectedLocation.forward();
        ship.executeCommands("f");
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenReceiveCommandWithBThenBackward() {
        Location expectedLocation = location.copy();
        expectedLocation.backward();
        ship.executeCommands("b");
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenReceiveCommandsThenAllAreExecuted() {
        Location expectedLocation = location.copy();
        expectedLocation.backward();
        expectedLocation.turnRight();
        expectedLocation.forward();
        expectedLocation.turnLeft();
        ship.executeCommands("brfl");
        assertEquals(ship.getLocation(), expectedLocation);
    }

    public void whenInstantiatedThenPlanetIsStored() {
        assertEquals(ship.getPlanet(), planet);
    }

    public void whenOverpassEastBoundaryThenLocation1() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(planet.getMax().getX());
        ship.executeCommands("f");
        assertEquals(location.getX(),1);
    }

    public void whenOverpassBackwardEastBoundaryThenLocation50() {
        location.setDirection(Direction.EAST);
        location.getPoint().setX(1);
        ship.executeCommands("b");
        assertEquals(location.getX(),50);
    }

    public void whenDetectObstacleThenMoveIsAborted() {
        location.setDirection(Direction.EAST);
        ship.executeCommands("fff");
        assertEquals(location.getX(),13);
    }

    public void whenMoveIsAbortedThenReportsObstacles() {
        location.setDirection(Direction.EAST);
        String report = ship.executeCommands("fff");
        assertEquals(report, "OOX");
    }

    private List<Point> getObstacleList() {
        List<Point> obstacles = new ArrayList<>();
        obstacles.add(new Point(14, 41));
        obstacles.add(new Point(18, 41));

        return obstacles;
    }

}
