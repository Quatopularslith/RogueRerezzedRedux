/* 
 * File:   floorGen.cpp
 * Author: Razim Zavac
 * 
 * Created on February 18, 2015, 12:46 PM
 */

#include "floorGen.h"
SDL_Surface *floorBlock;
bool floorGen::loadMedia() {
    bool success = true;
    floorBlock = SDL_LoadPNG();
    if(floorBlock == NULL){
        printf("Floor block load error: %s\n", SDL_GetError());
        success = false;
    }
    return success;
}


