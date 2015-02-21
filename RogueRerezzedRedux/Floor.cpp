/* 
 * File:   Floor.cpp
 * Author: Torri
 * 
 * Created on February 21, 2015, 4:08 PM
 */

#include "Floor.h"

const double chanceRoom = 0.5;

struct Floor::Point {
    int x;
    int y;
};

struct Floor::Room {
    int x;//top left
    int y;//top left
    int sizex;//right length
    int sizey;//down length
};

Floor::Floor() {
    Room room = new Room(rand() % 5, rand() % 5, 45, 45);
    Point check;
    bool cont = true;
    while(cont == true){
        makeFloor(room);
        check = pickWall();
    }
}

void Floor::makeFloor(Room room){
    for(int x = room.x; x < room.x + room.sizex; x++){
        for(int y = room.y; y < room.y + room.sizey; y++){
            setFloor(new Point(x, y), '#');
        }
    }
}

Floor::Point Floor::pickWall(){
    
}

bool Floor::isSpace(Point check){
    
}

void Floor::setFloor(Point p, char val){
    floor[p.x + width * p.y] = val;
}

char Floor::getFloor(Point p){
    return floor[p.x + width * p.y];
}

Floor::~Floor() {}

