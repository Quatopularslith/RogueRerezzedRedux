/* 
 * File:   main.cpp
 * Author: Razim Zavac
 *
 * Created on February 17, 2015, 6:20 PM
 */

#include <cstdlib>
#include <iostream>
#include <SDL.h>
#include "main.h";
using namespace std;

Main::main(int argc, char* args[]){
    SDL_Window** window;
    SDL_Renderer** renderer;
    SDL_Surface* screen = NULL;
    SDL_Init(SDL_INIT_EVERYTHING);
    SDL_CreateWindowAndRenderer(640, 480, SDL_WINDOW_OPENGL, window, renderer);
    return 0;
}

