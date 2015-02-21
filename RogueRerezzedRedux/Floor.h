/* 
 * File:   Floor.h
 * Author: Torri
 *
 * Created on February 21, 2015, 4:08 PM
 */

#ifndef FLOOR_H
#define	FLOOR_H

class Floor {
public:
    Floor();
    virtual ~Floor();
private:
    void makeFloor(int,int,int,int);
    void setFloor(Point, char);
    char getFloor(Point);
    Point pickWall();
    bool isSpace(Point);
    struct Point;
    struct Room;
    const int width = 100;
    const int height = 100;
    /**
     * # = floor
     * D = door
     * T = trap
     * S = secret door
     * @ = player spawn
     * * = enemy spawn
     */
    char floor[width + width * height];
};

#endif	/* FLOOR_H */

