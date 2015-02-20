/* 
 * File:   floorGen.cpp
 * Author: Razim Zavac
 * 
 * Created on February 18, 2015, 12:46 PM
 */

#include "FloorGen.h"
#include <SDL_image.h>
#include <stdio.h>
#include <string>
#include "Media.h"

bool FloorGen::loadFloor(){
    FloorGen f;
    Media m;
    SDL_Surface* floorBlock = NULL;
    //floorBlock = m.loadIMG("floor.png");
}

//bool floorGen::doesFloorGenLoad(){
//    bool success = true;
//    if(!fGfG.loadFloor()){
//        printf("Floor failed to load");
//        success = false;
//    }
//    return success;
//}
//
//bool floorGen::loadFloor(){
//    SDL_Surface* floorBlock = NULL;
//    bool success = true;
//    floorBlock = fGlM.loadPNG("floor.png");
//    if(floorBlock == NULL){
//        printf("Floor Block failed to load\n");
//    }
//    return success;
//}
