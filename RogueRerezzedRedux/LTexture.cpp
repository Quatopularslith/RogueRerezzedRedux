/* 
 * File:   LTexture.cpp
 * Author: Razim
 * 
 * Created on February 20, 2015, 3:50 PM
 */

#include "LTexture.h"
#include "Main.h"
#include <stdio.h>
#include <SDL.h>
#include <SDL_image.h>
#include <string>
LTexture::LTexture(std::string texture) {
    rTexture = NULL;
    rWidth = 0; 
    rHeight = 0;
    loadTexture(texture);
}

LTexture::~LTexture() {
    freeTexture();
}

bool LTexture::loadTexture(std::string texture){
    Main m;
    freeTexture();
    SDL_Texture* newTexture = NULL;
    SDL_Surface* loadedSurface = IMG_Load(texture.c_str());
    if(loadedSurface == NULL) printf("Unable to load %s. SDL_image error: %s\n", texture.c_str(), IMG_GetError());
    else{
        SDL_SetColorKey(loadedSurface, SDL_TRUE, SDL_MapRGB(loadedSurface->format, 0, 0xFF, 0xFF));
        newTexture = SDL_CreateTextureFromSurface(m.renderer, loadedSurface);
        if(newTexture == NULL) printf("Unable to make texture from %s. SDL Error: %s\n", texture.c_str(), SDL_GetError());
        else{
            rWidth = loadedSurface->w;
            rHeight = loadedSurface->h;
        }
        SDL_FreeSurface(loadedSurface);
    }
    rTexture = newTexture;
    return rTexture != NULL;
}
#ifdef _SDL_TTF_H
bool LTexture::loadText(std::string text, SDL_Color textColor){
    free();
    SDL_Surface* textSurface = TTF_RenderText_Solid(gFont, text.c_str(), textColor);
    if(textSurface != NULL){
        rTexture = SDL_CreateTextureFromSurface(m.renderer, textSurface);
        if(rTexture == NULL) printf("Unable to create text. SDL Error: %s\n", SDL_GetError());
        else{
            rWidth = textSurface->w;
            rHeight = textSurface->h;
        }
        SDL_FreeSurface(textSurface);
    }else printf("Unable to render text surface. SDL_ttf error: %s\n", TTF_GetError());
    return rTexture != NULL;
}
#endif

void LTexture::freeTexture(){
    if(rTexture != NULL){
        SDL_DestroyTexture(rTexture);
        rTexture = NULL;
        rWidth = 0;
        rHeight = 0;
    }
}

void LTexture::setColor(Uint8 red, Uint8 green, Uint8 blue){
    SDL_SetTextureColorMod(rTexture, red, green, blue);
}

void LTexture::setBlendMode(SDL_BlendMode blending){
    SDL_SetTextureBlendMode(rTexture, blending);
}

void LTexture::setAlpha(Uint8 alpha){
    SDL_SetTextureAlphaMod(rTexture, alpha);
}

void LTexture::render(int x, int y, SDL_Rect* clip, double angle, SDL_Point* center, SDL_RendererFlip flip){
    Main m;
    SDL_Rect renderQuad = {x, y, rWidth, rHeight};
    if(clip != NULL){
        renderQuad.w = clip->w;
        renderQuad.h = clip->h;
    }
    SDL_RenderCopyEx(m.renderer, rTexture, clip, &renderQuad, angle, center, flip);
}

int LTexture::getWidth(){
    return rWidth;
}

int LTexture::getHeight(){
    return rHeight;
}