/* 
 * File:   main.h
 * Author: Razim
 *
 * Created on February 18, 2015, 10:06 AM
 */

#ifndef MAIN_H
#define	MAIN_H

class Main{
public:
    static SDL_Window *window;
    static SDL_Renderer *renderer;
    static SDL_Surface *screenSurface;
    static bool init();
private:
};

#endif	/* MAIN_H */

