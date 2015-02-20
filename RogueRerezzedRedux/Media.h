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
    void freeTexture();
    bool loadTexture(string texture);
    SDL_Renderer* renderer = NULL;
    void renderLoop();
    void setColor(Uint8 red, Uint8 green, Uint8 blue);
    void render(int x, int y,SDL_Rect* clip = NULL);
    int getWidth();
    int getHeight();
    bool loadMedia();
    SDL_Surface* loadImg(string img);
private:
    SDL_Texture* rTexture;
    int rWidth;
    int rHeight;
};

#endif	/* LOADMEDIA_H */

