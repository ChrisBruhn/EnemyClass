package prog;
import robocode.*;

public class EnemyBot {

    private int bearing, distance, energy, heading, velocity;
    private String name;

    public void EnemyBot(){
        this.reset();

    }

    public void setScannedBearing(int sb){
        this.bearing = sb;
    }

    public void setScannedDistance(int sd){
        this.distance = sd;
    }

    public void setEnergy(int se){
    this.energy = se;
    }

    public void setName(String name){
        this.name = name;
    }

    public void update(ScannedRobotEvent event){
/*
        bearing = event.getBearing();
        distance = event.getDistance();
        energy = event.getEnergy();
        heading = event.getHeading();
        velocity = event.getVelocity();
        name = event.getName();

 */
    }

    public void reset(){
        bearing = 0;
        distance = 0;
        energy = 0;
        heading = 0;
        velocity = 0;
        name = "";
    }
    public boolean none(){

        if (this.name == "")
            return true;
        else
            return false;
    }

    public double getBearing(){
        return this.bearing;
    }
    public double getDistance(){
        return this.distance;
    }
    public double getEnergy(){
        return this.energy;
    }
    public double getHeading(){
        return this.heading;
    }
    public String getName(){
        return this.name;
    }
    public double getVelocity(){
        return this.velocity;
    }
}
