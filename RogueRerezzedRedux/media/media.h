/* 
 * File:   loadMedia.h
 * Author: Razim Zavac
 *
 * Created on February 18, 2015, 4:00 PM
 */

#ifndef LOADMEDIA_H
#define	LOADMEDIA_H
#include <SDL.h>
#include <SDL_image.h>
#include <string>
using namespace std;
class media {
public:
    media();
    bool doesMediaLoad();
    SDL_Surface* loadPNG(string path);
private:

};

#endif	/* LOADMEDIA_H */

