/* 
 * File:   loadMedia.cpp
 * Author: Razim Zavac
 * 
 * Created on February 18, 2015, 4:00 PM
 */

#include "Media.h"
#include "Main.h"
#include "Main.h"
#include "FloorGen.h"
#include <SDL_image.h>
#include <SDL.h>
#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

Media::Media(){
    rTexture = NULL;
    rWidth = 0;
    rHeight = 0;
}

bool Media::loadMedia(){
    Media m;
    if(!m.loadImg("")){
        return false;
    }
    return true;
}

void Media::loadTexture(string texture){
    Media m;
    m.freeTexture();
    SDL_Texture* newTexture = NULL;
    SDL_Surface* loadedSurface = IMG_Load(texture.c_str());
    if(loadedSurface == NULL){
        printf("Texture load error: %s\n SDL_image: %s\n", texture.c_str(), IMG_GetError());
    }else{
        SDL_SetColorKey(loadedSurface, SDL_TRUE, SDL_MapRGB(loadedSurface->format, 0, 0xFF, 0xFF));
        newTexture = SDL_CreateTextureFromSurface(renderer, loadedSurface);
        if(newTexture == NULL){
            printf("Unable to create texture from %s\n. SDL: %\n", texture.c_str(), SDL_GetError());
        }else{
            rWidth = loadedSurface->w;
            rHeight = loadedSurface->h;
        }
        SDL_FreeSurface(loadedSurface);
    }
    rTexture = newTexture;
    return rTexture != NULL;
}

void Media::freeTexture(){
    if(rTexture != NULL){
        SDL_DestroyTexture(rTexture);
        rTexture = NULL;
        rWidth = 0;
        rHeight = 0;
    }
}

void Media::setColor(Uint8 red, Uint8 green, Uint8 blue){
    SDL_SetTextureColorMod(rTexture, red, green, blue);
}

void Media::render(int x, int y, SDL_Rect* clip){
    SDL_Rect renderQuad = {x, y, rWidth, rHeight};
    if(clip != NULL){
        renderQuad.w = clip->w;
        renderQuad.h = clip->h;
    }
    SDL_RenderCopy(renderer, rTexture, clip, &renderQuad);
}

int Media::getWidth(){
    return rWidth;
}
int Media::getHeight(){
    return rHeight;
}

SDL_Surface* Media::loadImg(string img){
    SDL_Surface *image;
    image = IMG_Load(img.c_str());
    if(!image){
        image = NULL;
        cout << "Image: " << img << " failed to load\n";
        printf("Error: %s\n", IMG_GetError());
    }
    return image;
}