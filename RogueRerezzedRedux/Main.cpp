/* 
 * File:   main.cpp
 * Author: Razim Zavac & Torri
 *
 * Created on February 17, 2015, 6:20 PM
 */

#include <cstdlib>
#include <iostream>
#include <stdio.h>
#include <SDL.h>
#include <SDL_image.h>
#include "Main.h"
#include "Floor.h"
#include "Media.h"
#include "Player.h"
#include "LTexture.h"

const int WINDOW_WIDTH = 640;
const int WINDOW_HEIGHT = 580;
using namespace std;

bool Main::init(){
    if(SDL_Init(SDL_INIT_VIDEO) < 0){
        printf("SDL_Init: %s\n", SDL_GetError());
        return false;
    }else{
        if(!SDL_SetHint(SDL_HINT_RENDER_VSYNC, "1")) printf("Vsync Not Enabled");
        if(!SDL_SetHint(SDL_HINT_RENDER_SCALE_QUALITY, "1")) printf("Linear texture filtering not enabled\n");
    }
        window = SDL_CreateWindow("RogueRerezzedRedux", WINDOW_WIDTH, WINDOW_HEIGHT, SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, 0);
        if(window == NULL){printf("Window Creation: %s\n", SDL_GetError());return false;
        }else{
            renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
            if(renderer == NULL){printf("Renderer creation failed: %s\n", SDL_GetError()); return false;
            }else{
                SDL_SetRenderDrawColor(renderer, 0xFF, 0xFF, 0xFF, 0xFF);
                if(!IMG_Init(IMG_INIT_PNG)){printf("IMG_Init: %s\n", IMG_GetError()); return false;
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
    if(!m.init()){ printf("Initialization failed");
    }else{
        bool quit = false;
        SDL_Event e;
        
        LTexture floorTexture("floor.png");
        
        //Player player1(100, 0, 0);
        
        while(!quit){
            while(SDL_PollEvent(&e) != 0){
                if(e.type == SDL_QUIT){
                    quit = true;
                }
            }
            SDL_SetRenderDrawColor(m.renderer, 0, 0, 0, 255);
            SDL_RenderClear(m.renderer);
            
            //player1.render();
            
            SDL_RenderPresent(m.renderer);
        }
       // floorTexture.freeTexture();
       // playerTexture.freeTexture();
        SDL_DestroyRenderer(m.renderer);
        SDL_DestroyWindow(m.window);
        m.window = NULL;
        m.renderer = NULL;
        IMG_Quit();
        SDL_Quit();
    }
}
