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
        return location.forward(planet.getMax(), planet.getObstacles());
    }

    public boolean moveBackward() {
        return location.backward(planet.getMax(), planet.getObstacles());
    }

    public void turnLeft() {
        location.turnLeft();
    }

    public void turnRight() {
        location.turnRight();
    }

    public String executeCommands(String commands) {
        StringBuilder report = new StringBuilder();
        for (char command : commands.toUpperCase().toCharArray()) {
            report.append(executeIndividualCommand(command));
        }
        return report.toString();
    }

    private String executeIndividualCommand(char command) {
        String result = "";
        switch (command) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'F':
                result = moveForward() ? "O" : "X";
                break;
            case 'B':
                result = moveBackward() ? "O" : "X";
                break;
            default:
                break;
        }

        return result;
    }

    public Planet getPlanet() {
        return planet;
    }
}
