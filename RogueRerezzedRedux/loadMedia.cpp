/* 
 * File:   loadMedia.cpp
 * Author: Razim Zavac
 * 
 * Created on February 18, 2015, 4:00 PM
 */

#include "loadMedia.h"
#include <SDL_image.h>
#include <stdio.h>
#include <string>

bool loadMedia(){
    bool success = true;
    if(!loadMedia::loadPNG()){
        success = false;
    }
    return success;
}

SDL_Surface* loadMedia::loadPNG(std::string path) {
    SDL_Surface* optimizedImg = NULL;
    SDL_Surface* img = IMG_Load(path.c_str());
    if(img == NULL){
        printf("img load error: %s\n", SDL_GetError());
    }else{
        optimizedImg = SDL_ConvertSurface(img, Main::screenSurface->format, NULL);
        if(optimizedImg == NULL){
            printf("Floor optimization error: %s\n", SDL_GetError());
        }
        SDL_FreeSurface(img);
    }
    return optimizedImg();
}

