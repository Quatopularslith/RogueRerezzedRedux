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
#include "main.h"
using namespace std;

SDL_Window *window;
SDL_Surface *screenSurface;
const int width = 640;
const int height = 480;

int init(){
    bool success = true;
    if(SDL_Init(SDL_INIT_VIDEO) < 0){
        printf("Initialization error: %s\n", SDL_GetError());
        success = false;
    }else{
        window = SDL_CreateWindow("RogueRerezzedRedux", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, height, width, SDL_WINDOW_OPENGL);
        if(window == NULL){
            printf("Window creation error: %s\n", SDL_GetError());
            success = false;
        }else{
            screenSurface = SDL_GetWindowSurface(window);
        }
    }
    return success;
}
int quit(){
    SDL_DestroyWindow(window);
    SDL_FreeSurface(screenSurface);
    SDL_Quit();
}
int main(int argc, char* args[]){
    init();
    SDL_Delay(3000);
    quit();
    return 0;
}

