# EpoctiAA - kokoscript
Antialiasing algorithm for pixel art

## What is it?
EpoctiAA is a simple anti-aliasation algorithm that was originally put to use while creating assets for the game *ExaStar*. At first, this anti-aliasing was done manually - however, this no longer needs to be the case.

## How does it work?
(The checking color is the color that is to be anti-aliased. Additionally, each pixel that contains the same RGB vals as the checking color won't be checked.)

Essentially, the algorithim checks for at least one of the following out of each pixel:
- Pixels with the checking color to the top and to the left
- Pixels with the checking color to the top and to the right
- Pixels with the checking color to the bottom and to the left
- Pixels with the checking color to the bottom and to the right

If any of these conditions are met, the checking color (with an alpha value of 74) will be applied to that pixel.
