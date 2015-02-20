/* 
 * File:   main.cpp
 * Author: Razim Zavac
 *
 * Created on February 17, 2015, 6:20 PM
 */

#include <cstdlib>
#include <iostream>
#include <stdio.h>
#include <SDL.h>
#include <SDL_image.h>
#include "Main.h"
#include "FloorGen.h"
#include "Media.h"

const int WINDOW_WIDTH = 640;
const int WINDOW_HEIGHT = 480;
using namespace std;

bool Main::init(){
    if(!SDL_Init(SDL_INIT_VIDEO)){
        printf("SDL_Init: %s\n", SDL_GetError());
        return false;
    }else{
        window = SDL_CreateWindow("RogueRerezzedRedux", WINDOW_WIDTH, WINDOW_HEIGHT, SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, SDL_WINDOW_RESIZABLE);
        if(window == NULL){
            printf("Window Creation: %s\n", SDL_GetError());
            return false;
        }else{
            if(!IMG_Init(IMG_INIT_PNG)){
                printf("IMG_Init: %s\n", IMG_GetError());
                return false;
            }else{
                screenSurface = SDL_GetWindowSurface(window);
            }
        }
    }
    return true;
}
int main(int argc, char* args[]){
    Main m;
    Media me;
    FloorGen f;
    if(!m.init()){
        printf("Initialization failed");
    }else{
        if(!me.loadMedia()){
            printf("Failed to load media");
        }else{
            if(!f.loadFloorGen()){
                printf("FloorGen failed");
            }
        }
    }
}