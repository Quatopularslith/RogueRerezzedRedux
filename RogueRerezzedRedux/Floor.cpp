/* 
 * File:   Floor.cpp
 * Author: Torri
 * 
 * Created on February 21, 2015, 4:08 PM
 */

#include "Floor.h"

const double chanceRoom = 0.5;

Floor::Floor() {
    int sizex = rand() % 5;
    int sizey = rand() % 5;
    int cx = 50 - sizex;
    int cy = 50 - sizey;
    bool cont = true;
    while(cont == true){
        makeFloor(cx, cy, sizex, sizey);
        
    }
}

void Floor::makeFloor(int cornerx, int cornery, int sizex, int sizey){
    for(int x = cornerx; x < cornerx + sizex; x++){
        for(int y = cornery; y < cornery + sizey; y++){
            setFloor(x, y, '#');
        }
    }
}

void Floor::setFloor(int x, int y, char val){
    floor[x + 100 * y] = val;
}

Floor::~Floor() {
}

