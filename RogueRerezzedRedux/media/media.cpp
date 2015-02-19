/* 
 * File:   loadMedia.cpp
 * Author: Razim Zavac
 * 
 * Created on February 18, 2015, 4:00 PM
 */

#include "media.h"
#include "../core/main.h"
#include <SDL_image.h>
#include <SDL.h>
#include <stdio.h>
#include <string>
using namespace std;
media mlM;
Main mm;
media::media(){
    
}
bool media::doesMediaLoad(){
    bool success = true;
    if(!mlM.loadPNG("floor.png")){
        success = false;
    }
    return success;
}

SDL_Surface* media::loadPNG(string path) {
    SDL_Surface* optimizedImg = NULL;
    SDL_Surface* img = IMG_Load(path.c_str());
    if(img == NULL){
        printf("img load error: %s\n", SDL_GetError());
    }else{
        optimizedImg = SDL_ConvertSurface(img, mm.screenSurface->format, 0);
        if(optimizedImg == NULL){
            printf("Floor optimization error: %s\n", SDL_GetError());
        }
        SDL_FreeSurface(img);
    }
    //return optimizedImg();
}

