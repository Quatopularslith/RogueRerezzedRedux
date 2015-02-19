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
#include "../floorGen/floorGen.h"
#include "../media/media.h"
Main m;
floorGen fG;
media lM;
const int width = 640;
const int height = 480;
using namespace std;

int Main::init(){
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
            if(!(IMG_Init(IMG_INIT_PNG)& IMG_INIT_PNG)){
                printf("SDL_Image error: %s\n", IMG_GetError());
                success = false;
            }else{
            screenSurface = SDL_GetWindowSurface(window);
            }
        }
    }
    return success;
}
void Main::quit(){
    SDL_DestroyWindow(window);
    SDL_FreeSurface(screenSurface);
    SDL_Quit();
}
int main(int argc, char* args[]){
    if(!m.init()){
        printf("Init failed");
    }else{
        if(!lM.loadPNG("")){
            printf("Floor failed to load");
        }else{
            SDL_Event e;
            bool quit = false;
            while(!quit){
                while(SDL_PollEvent(&e) != 0){
                    if(e.type == SDL_QUIT){
                        quit = true;
                    }
                }
                //SDL_BlitSurface();
            }
        }
    }
    return 0;
}

