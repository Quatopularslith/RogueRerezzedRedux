/* 
 * File:   floorGen.cpp
 * Author: Razim Zavac
 * 
 * Created on February 18, 2015, 12:46 PM
 */

#include "floorGen.h"
#include <SDL_image.h>
#include <stdio.h>
#include <string>
#include "../media/media.h"

floorGen::floorGen(){
    
}

bool floorGen::doesFloorGenLoad(){
    bool success = true;
    if(!fGfG.loadFloor()){
        printf("Floor failed to load");
        success = false;
    }
    return success;
}

bool floorGen::loadFloor(){
    SDL_Surface* floorBlock = NULL;
    bool success = true;
    floorBlock = fGlM.loadPNG("floor.png");
    if(floorBlock == NULL){
        printf("Floor Block failed to load\n");
    }
    return success;
}
