/* 
 * File:   Item.cpp
 * Author: Torri
 * 
 * Created on February 19, 2015, 7:47 PM
 */

#include "Item.h"
#include <string>
#include <stdio.h>
#include <map>
#include <iostream>

using namespace std; 

/*
 *  READ THIS TORRI
 *  OK SO MAYBE YOU DON'T LIKE ITS NOT STATIC AND CONST AND CRAP
 *  DEAL WITH IT FOR NOW BECUASE IT WORKS LIKE THIS
 * 
 *  BTW YOU REALIZE WHEN YOU'RE USING THIS->ID = ID;
 *  YOU'RE TRYING TO ASSING A VARIABLE TO A CONST INT
 *  YOU KNOW THAT RIGHT?
 */

int Item::ItemThing(int id){
    const static string keys[] = {
        "weapon", "armor",
        "other", "material",
        "modifier"
    };
    map<string, string> item;
    item["weapon"] = 
        "Sword", "Axe",
        "Bow", "Crossbow",
        "Wand", "Staff"
    ;
    item["armor"] = 
        "Helm", "Chestpiece",
        "Greaves", "Boots",
        "Ring"
    ;
    item["other"] = 
        "Scroll", "Tome",
        "Potion", "Gold",
        "Food", "Note",
        "Crystal Shard"
    ;
    item["material"] = 
        "Leather", "Chainmail",
        "Iron", "Steel",
        "Hyperium", "Alanium",
        "Tsinium", "Visium"
    ;
    item["modifier"] = 
        "Cursed", "Broken", "Weak",
        "Good", "Great", "Legendary",
        "Powerful", "Magical", "Ancient"
    ;
    id = id;
    string name = "";
    int mod = id % item["modifier"].size();
    int mat = id % item["material"].size();
    int type = id % (item["weapon"].size() + item["armor"].size() + item["other"].size());
    name += item["modifier"][mod];
    name += " "; 
    name += item["material"][mat];
}