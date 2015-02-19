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
    SDL_Window *window;
    SDL_Surface *screenSurface;
    bool init();
    void quit();
private:
};

#endif	/* MAIN_H */

