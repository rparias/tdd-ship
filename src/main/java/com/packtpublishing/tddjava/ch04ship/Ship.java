package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private final Location location;
    private final Planet planet;

    public Ship(Location location, Planet planet) {
        this.location = location;
        this.planet = planet;
    }

    public Location getLocation() {
        return location;
    }

    public boolean moveForward() {
        return location.forward(planet.getMax());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax());
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

    public Planet getPlanet() {
        return planet;
    }
}
