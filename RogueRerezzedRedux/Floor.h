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
    void setFloor(int,int,char);
    virtual ~Floor();
private:
    void makeFloor(int,int,int,int);
    /**
     * # = floor
     * D = door
     * T = trap
     * S = secret door
     * @ = player spawn
     * * = enemy spawn
     */
    char floor[100 + 100 * 100];
};

#endif	/* FLOOR_H */

