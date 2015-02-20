/* 
 * File:   Item.cpp
 * Author: Torri
 * 
 * Created on February 19, 2015, 7:47 PM
 */

#include "Item.h"
#include "Entity.h"
#include <string>
#include <stdio.h>
#include <map>
#include <iostream>

using namespace std;

static string weapon[] = {
    "Sword", "Axe",
    "Bow", "Crossbow",
    "Wand", "Staff"
};
static string armor[] = {
    "Helm", "Chestpiece",
    "Greaves", "Boots",
    "Ring"
};
static string tool[] = {
    "Pickaxe", "Drill",
    "Chisel", "Magnifying Glass",
    "Hammer", "Lockpick"
};
static string other[] = {
    "Scroll", "Tome",
    "Potion", "Gold",
    "Food", "Note",
    "Crystal Shard"
};
static string material[] = {
    "Leather", "Chainmail",
    "Iron", "Steel",
    "Hyperium", "Alanium",
    "Tsinium", "Visium"
};
static string modifier[] = {
    "Cursed", "Broken", "Weak",
    "Good", "Great", "Legendary",
    "Powerful", "Magical", "Ancient"
};

Item::Item(int _id) : Entity(0, 0) {
    id = _id;
    string name = "";
    int mod = id % sizeof(modifier);
    int mat = id % sizeof(material);
    int type = id % (sizeof(weapon) + sizeof(armor) + sizeof(tool) + sizeof(other));
    name += modifier[mod];
    name += " "; 
    name += material[mat];
    name += " ";
    if(type < sizeof(weapon)){
        name += weapon[type];
    }else if(type < sizeof(weapon) + sizeof(armor)){
        type -= sizeof(weapon);
        name += armor[type];
    }else if(type < sizeof(weapon) + sizeof(armor) + sizeof(tool)){
        type -= sizeof(weapon);
        type -= sizeof(armor);
        name += tool[type];
    }else{
        type -= sizeof(weapon);
        type -= sizeof(armor);
        type -= sizeof(tool);
        name = Item::otherNamer(type);
    }
    this->name = name;
}

string Item::getName(){
    return name;
}
int Item::getID(){
    return id;
}
string Item::otherNamer(int type){
    if(type == 0){
        
    }
}