/* 
 * File:   Item.h
 * Author: Torri
 *
 * Created on February 19, 2015, 7:47 PM
 */

#ifndef ITEM_H
#define	ITEM_H

#include <string>
#include <stdio.h>
#include <map>

using namespace std;

class Item {
public:
    const static string keys[] = {
        "weapon", "armor",
        "other", "material",
        "modifier"
    };
    const static map<string, string[]> item;
    item["weapon"] = {
        "Sword", "Axe",
        "Bow", "Crossbow",
        "Wand", "Staff"
    };
    item["armor"] = {
        "Helm", "Chestpiece",
        "Greaves", "Boots",
        "Ring"
    };
    item["other"] = {
        "Scroll", "Tome",
        "Potion", "Gold",
        "Food", "Note",
        "Crystal Shard"
    };
    item["material"] = {
        "Leather", "Chainmail",
        "Iron", "Steel",
        "Hyperium", "Alanium",
        "Tsinium", "Visium"
    };
    item["modifier"] = {
        "Cursed", "Broken", "Weak",
        "Good", "Great", "Legendary",
        "Powerful", "Magical", "Ancient"
    };
    const string intname;
    const string name;
    Item();
protected:
    const int id;
    
};

#endif	/* ITEM_H */

