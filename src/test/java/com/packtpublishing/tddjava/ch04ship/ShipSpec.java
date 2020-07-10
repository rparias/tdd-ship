package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    private Ship ship;
    private Location location;

    @BeforeMethod
    public void beforeTest() {
        location = new Location(new Point(11, 91), Direction.NORTH);
        ship = new Ship(location);
    }

    public void whenInstantiatedThenLocationIsSet() {
        assertEquals(ship.getLocation(), location);
    }

    public void givingNorthWhenMoveForwardThenYDecrease() {
        ship.moveForward();
        assertEquals(ship.getLocation().getPoint().getY(), 90);
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

}
