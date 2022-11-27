import java.lang.Math;

public class Animal {
    protected int ttl, size, speed, matingCooldown, direction, directionCooldown;
    protected float strength;
    protected int posX, posY;
    protected String type;

    public Animal() {
        this.ttl = 15 * 60; // 15 seconds à 60 ticks
        this.matingCooldown = 5 * 60; // Cooldown of 5 seconds, 1/3 of ttl
        this.directionCooldown = 0;
    }

    public void walk() {
        if (directionCooldown == 0) {
            direction = (int) (Math.random() *  7); // Selecting a random direction
            directionCooldown = (int) (Math.random() * 2 * 60) + 60; // Setting directionCooldown between 1-3 seconds
        }
        switch (direction) {
            case 0: posY -= speed;                // up
            case 1: posX += speed; posY -= speed; // up-right
            case 2: posX += speed;                // right
            case 3: posX += speed; posY += speed; // down-right
            case 4: posY += speed;                // down
            case 5: posX -= speed; posY += speed; // down-left
            case 6: posX -= speed;                // left
            case 7: posX -= speed; posY -= speed; // up-left
        }

    }
    public boolean isAlive() {
        if (ttl > 0) {
            return true;
        } else {
            return false;
        }
    }
    public int[] getPos() {
        return new int[]{posX, posY};
    }
}
