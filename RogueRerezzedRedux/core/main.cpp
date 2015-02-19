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
#include "main.h"
//#include "../floorGen/floorGen.h"
#include "../media/media.h"
static Main m;
//floorGen fG;
media lM;
const int width = 640;
const int height = 480;
using namespace std;

bool Main::init(){
    if(!SDL_Init(SDL_INIT_VIDEO)){
        printf("SDL_Init: %s\n", SDL_GetError());
        return false;
    }else{
        window = SDL_CreateWindow("RogueRerezzedRedux", width, height, SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, SDL_WINDOW_RESIZABLE);
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

}