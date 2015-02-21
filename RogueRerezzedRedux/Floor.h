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
    char floor[100][100];
    /**
     * # = floor
     * D = door
     * T = trap
     * S = secret door
     */
    virtual ~Floor();
private:

};

#endif	/* FLOOR_H */

