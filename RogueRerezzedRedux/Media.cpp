/* 
 * File:   loadme.cpp
 * Author: Mnenmenth
 * 
 * Created on February 18, 2015, 4:00 PM
 */

#include "Media.h"
#include "Main.h"
#include "Main.h"
#include "Floor.h"
#include <SDL_image.h>
#include <SDL.h>
#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

Media::Media(){

}

bool Media::loadMedia(){
    Media me;
    return true;
}

SDL_Surface* Media::loadImg(string img){
    SDL_Surface *image;
    image = IMG_Load(img.c_str());
    if(!image){
        image = NULL;
        cout << "Image: " << img << " failed to load\n";
        printf("Error: %s\n", IMG_GetError());
    }
    return image;
}