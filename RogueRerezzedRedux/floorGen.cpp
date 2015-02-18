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

bool loadFloor(){
    SDL_Surface* floorBlock = NULL;
    bool success = true;
    floorBlock = loadMedia::loadPNG("floor.png");
    if(floorBlock == NULL){
        printf("Floor Block failed to load\n");
    }
    return success;
}
