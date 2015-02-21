/* 
 * File:   Entity.cpp
 * Author: Torri
 * 
 * Created on February 20, 2015, 4:05 PM
 */

#include "Entity.h"
#include "LTexture.h"
#include <stdio.h>
#include <string>

using namespace std;

Entity::Entity(int _x, int _y, string path) {
    x = _x;
    y = _y;
    tpath = path;
    loadTex(path);
}

Entity::~Entity(){
    //tpath = NULL;
}

void Entity::loadTex(string path){
    /*if(path == NULL){
        return;
    }*/
    /*if(!textures[path]){
        textures.insert(std::make_pair(path, *LTexture(path)));
    }*/
}

void Entity::render(){
    /*if(textures[tpath] != NULL){
        (*textures[tpath]).render(x, y);
    }else{printf("Texture %s is null\n", (*textures[tpath]).getTexturePath());}*/
}

void Entity::moveTo(int newX, int newY){
    x = newX;
    y = newY;
}