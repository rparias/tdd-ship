package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private final Location location;

    public Ship(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean moveForward() {
        return location.forward();
    }

    public boolean moveBackward() {
        return location.backward();
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public void executeCommands(String commands) {
        for (char command : commands.toUpperCase().toCharArray()) {
            executeIndividualCommand(command);
        }
    }

    private void executeIndividualCommand(char command) {
        switch (command) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'F':
                moveForward();
                break;
            case 'B':
                moveBackward();
                break;
            default:
                break;
        }
    }
}
