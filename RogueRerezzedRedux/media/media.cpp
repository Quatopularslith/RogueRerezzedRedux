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

media::media(){
    
}

bool media::loadMedia(){
    if(!main::m.lM::loadImg("floor.png")){
        return false;
    }
}

SDL_Surface* media::loadImg(string img){
    SDL_Surface *image;
    SDL_RWops *rwop;
    rwop = SDL_RWFromFile(img, "rb");
    image = IMG_LoadPNG_RW(rwop);
    if(!image){
        image = NULL;
        cout << "Image: " << img << " failed to load\n";
        printf("Error: %s\n", IMG_GetError());
    }
    return image;
}