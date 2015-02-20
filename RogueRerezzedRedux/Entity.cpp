/* 
 * File:   Entity.cpp
 * Author: Torri
 * 
 * Created on February 20, 2015, 4:05 PM
 */

#include "Entity.h"
#include "LTexture.h"
#include <stdio.h>

Entity::Entity(int _x, int _y, LTexture* tex) {
    x = _x;
    y = _y;
    texture = tex;
}

Entity::~Entity(){
    texture = NULL;
}

void Entity::render(){
    if(texture != NULL){
        (*texture).render(x, y);
    }else{printf("Texture is null\n");}
}