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
class Media {
public:
    Media();
    bool loadMedia();
    SDL_Surface* loadImg(string img);
private:
};

#endif	/* LOADMEDIA_H */

