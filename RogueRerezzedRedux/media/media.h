/* 
 * File:   loadMedia.h
 * Author: Razim Zavac
 *
 * Created on February 18, 2015, 4:00 PM
 */

#ifndef LOADMEDIA_H
#define	LOADMEDIA_H
#include <SDL.h>
using namespace std;
class media {
public:
    media();
    bool loadMedia();
    SDL_Surface* loadPNG(string path);
private:

};

#endif	/* LOADMEDIA_H */

