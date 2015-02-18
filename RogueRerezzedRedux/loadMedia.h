/* 
 * File:   loadMedia.h
 * Author: Razim Zavac
 *
 * Created on February 18, 2015, 4:00 PM
 */

#ifndef LOADMEDIA_H
#define	LOADMEDIA_H

class loadMedia {
public:
    bool loadMedia();
    SDL_Surface* loadPNG(std::string path);
private:

};

#endif	/* LOADMEDIA_H */

