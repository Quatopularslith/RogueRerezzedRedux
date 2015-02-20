/* 
 * File:   LTexture.h
 * Author: Razim
 *
 * Created on February 20, 2015, 3:50 PM
 */

#ifndef LTEXTURE_H
#define	LTEXTURE_H
#include <stdio.h>
#include <string>
#include <SDL.h>
#include <SDL_image.h>
class LTexture {
public:
    LTexture(std::string texture);
    ~LTexture();
#ifdef _SDL_TTF_H
    bool loadText(std:string text, SDL_Color textColor);
#endif
    void freeTexture();
    void setColor(Uint8 red, Uint8 green, Uint8 blue);
    void setBlendMode(SDL_BlendMode blending);
    void setAlpha(Uint8 alpha);
    void render(int x, int y, SDL_Rect* clip = NULL, double angle = 0.0, SDL_Point* center = NULL, SDL_RendererFlip flip = SDL_FLIP_NONE);
    int getWidth();
    int getHeight();
private:
    bool loadTexture(std::string texture);
    SDL_Texture* rTexture;
    int rWidth;
    int rHeight;
};

#endif	/* LTEXTURE_H */

