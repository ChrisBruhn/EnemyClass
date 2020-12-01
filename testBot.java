package prog;

import robocode.AdvancedRobot;
import robocode.JuniorRobot;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Random;

public class testBot extends JuniorRobot {
    private EnemyBot enemy = new EnemyBot();

    public void run() {



        // reset the object
        enemy.reset();
        System.out.println("Object is set");
        //setAdjustRadarForRobotTurn(true);
        //setAdjustGunForRobotTurn(true);
        //setAdjustRadarForGunTurn(true);

        while (true) {
            turnGunLeft(360);
            //seek and destroy
            turnTo(avoidWall(heading,robotX,robotY,fieldHeight,fieldWidth));
            ahead(200);


        }

    }

    public void onScannedRobot() {
        int se = scannedEnergy;
        int sd = scannedDistance;
        int sb = scannedBearing;
        int sa = scannedAngle;
        int sh = scannedHeading;
        //

        if (enemy.none()) {
            enemy.setEnergy(se);
            enemy.setName("Tobias");
            System.out.println(" ENERGI IS SET TO: " + enemy.getEnergy()+" Navn: "+enemy.getName());
        }
        //stik halen mellem benene
        else {
            if (se>enemy.getEnergy()){
                System.out.println("Uhh Im running away!");
                // we are taking fire!
                // evasive actions
                if(sh<180) {
                    turnTo(sh + 180);
                }
                else{
                    turnTo(sh - 180);
                }


            }

        }



/*
        if (energy >= se){
            if ( sd< 600) {
                //turnGunTo(sb+heading);
                //turnGunTo(scannedBearing+heading);
                turnTo(scannedAngle);
                fire(2);
              //  System.out.println(se+" "+sd+" "+sb+" "+sa);
            }
        }
        else
        {
            turnTo(scannedAngle);
            fire(1);

        }

*/
    }


    public void onHitByBullet() {
        turnTo(gunHeading+90);
        ahead(100);
    }
    public void onWallHit(){
        turnGunLeft(360);
        turnGunLeft(360);
        turnGunLeft(360);
        System.out.println("WOW wall hit");
    }


    public void onHitRobot() {
        // aim your target
        System.out.println(scannedBearing+" "+scannedAngle+" "+heading);
        turnGunTo(scannedAngle);
        fire(3);
        back(30);
        ahead(100);


    }
    public static int avoidWall(int h, int xpos, int ypos, int fheight, int fwidth) {

        int newHeading =0;
        System.out.println("xpos: "+xpos+" ypos: "+ypos+"heading: "+h+" fheight: "+fheight);

        // syd
        if ((h > 90 && h <  270) && fheight/2<ypos) {
            int min=-40;
            int max=40;
            newHeading = (int)(Math.random()*(max-min+1)+min)+180;
            System.out.println("newHeading 0: "+newHeading);
        }
        // Nord
        else if ((h < 90 || h > 270 || h == 0) && fheight/2>ypos){
            int min=-40;
            int max=40;
            int deg = (int)(Math.random()*(max-min+1)+min);
            if (deg>0)
                newHeading = deg +0;
            else
                newHeading = deg -360;

            System.out.println("newHeading 1 :"+newHeading);
        }
        else if ((h < 360 || h > 180 ) && xpos<100){
            int min=20;
            int max=1600;
            newHeading = (int)(Math.random()*(max-min+1)+min);
            System.out.println("newHeading 2 :"+newHeading);
        }
        else if ((h > 0 || h < 180 ) && ypos>fwidth+400){
            int min=200;
            int max=320;
            newHeading = (int)(Math.random()*(max-min+1)+min);
            System.out.println("newHeading 3 :"+newHeading);
        }
        else {
            int min = 0;
            int max = 359;
            newHeading = (int) (Math.random() * (max - min + 1) + min);
            System.out.println("newHeading 4 :" + newHeading);
        }
        return newHeading;
    }
}
