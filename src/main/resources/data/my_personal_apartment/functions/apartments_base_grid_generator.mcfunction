#
# Copyright 2023 Markus Bordihn
#
# Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
# associated documentation files (the "Software"), to deal in the Software without restriction,
# including without limitation the rights to use, copy, modify, merge, publish, distribute,
# sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all copies or
# substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
# NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
# NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
# DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
#

tellraw @p {"text":"Apartments dimension base grid will be generated ...", "color":"gold", "bold":true}

# [0:0] Start Point 0 31 0 / End Point 48 79 48
# [0:0] Force load chunk for the grid
forceload add -32 -32 48 48

# [0:0] left
setblock 0 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 16 minecraft:redstone_block

# [0:0] left (column 0)
setblock 0 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 -32 minecraft:redstone_block

# [0:0] top
setblock 16 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 0 minecraft:redstone_block

# [0:0] top (row 0)
setblock -32 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 0 minecraft:redstone_block

# [0:0] Force unload chunk for the grid
forceload remove -32 -32 48 48


# [48:0] Start Point 48 31 0 / End Point 96 79 48
# [48:0] Force load chunk for the grid
forceload add 16 0 96 48

# [48:0] left
setblock 48 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 16 minecraft:redstone_block

# [48:0] left (column 0)
setblock 48 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 -32 minecraft:redstone_block

# [48:0] top
setblock 64 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 0 minecraft:redstone_block

# [48:0] Force unload chunk for the grid
forceload remove 16 0 96 48


# [96:0] Start Point 96 31 0 / End Point 144 79 48
# [96:0] Force load chunk for the grid
forceload add 64 0 144 48

# [96:0] left
setblock 96 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 16 minecraft:redstone_block

# [96:0] left (column 0)
setblock 96 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 -32 minecraft:redstone_block

# [96:0] top
setblock 112 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 0 minecraft:redstone_block

# [96:0] Force unload chunk for the grid
forceload remove 64 0 144 48


# [144:0] Start Point 144 31 0 / End Point 192 79 48
# [144:0] Force load chunk for the grid
forceload add 112 0 192 48

# [144:0] left
setblock 144 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 16 minecraft:redstone_block

# [144:0] left (column 0)
setblock 144 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 -32 minecraft:redstone_block

# [144:0] top
setblock 160 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 0 minecraft:redstone_block

# [144:0] Force unload chunk for the grid
forceload remove 112 0 192 48


# [192:0] Start Point 192 31 0 / End Point 240 79 48
# [192:0] Force load chunk for the grid
forceload add 160 0 240 48

# [192:0] left
setblock 192 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 16 minecraft:redstone_block

# [192:0] left (column 0)
setblock 192 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 -32 minecraft:redstone_block

# [192:0] top
setblock 208 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 0 minecraft:redstone_block

# [192:0] Force unload chunk for the grid
forceload remove 160 0 240 48


# [240:0] Start Point 240 31 0 / End Point 288 79 48
# [240:0] Force load chunk for the grid
forceload add 208 0 288 48

# [240:0] left
setblock 240 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 16 minecraft:redstone_block

# [240:0] left (column 0)
setblock 240 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 -32 minecraft:redstone_block

# [240:0] top
setblock 256 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 0 minecraft:redstone_block

# [240:0] Force unload chunk for the grid
forceload remove 208 0 288 48


# [288:0] Start Point 288 31 0 / End Point 336 79 48
# [288:0] Force load chunk for the grid
forceload add 256 0 336 48

# [288:0] left
setblock 288 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 16 minecraft:redstone_block

# [288:0] left (column 0)
setblock 288 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 -32 minecraft:redstone_block

# [288:0] top
setblock 304 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 0 minecraft:redstone_block

# [288:0] Force unload chunk for the grid
forceload remove 256 0 336 48


# [336:0] Start Point 336 31 0 / End Point 384 79 48
# [336:0] Force load chunk for the grid
forceload add 304 0 384 48

# [336:0] left
setblock 336 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 16 minecraft:redstone_block

# [336:0] left (column 0)
setblock 336 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 -32 minecraft:redstone_block

# [336:0] top
setblock 352 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 0 minecraft:redstone_block

# [336:0] Force unload chunk for the grid
forceload remove 304 0 384 48


# [384:0] Start Point 384 31 0 / End Point 432 79 48
# [384:0] Force load chunk for the grid
forceload add 352 0 432 48

# [384:0] left
setblock 384 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 16 minecraft:redstone_block

# [384:0] left (column 0)
setblock 384 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 -32 minecraft:redstone_block

# [384:0] top
setblock 400 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 0 minecraft:redstone_block

# [384:0] Force unload chunk for the grid
forceload remove 352 0 432 48


# [432:0] Start Point 432 31 0 / End Point 480 79 48
# [432:0] Force load chunk for the grid
forceload add 400 0 480 48

# [432:0] left
setblock 432 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 16 minecraft:redstone_block

# [432:0] left (column 0)
setblock 432 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 -32 minecraft:redstone_block

# [432:0] top
setblock 448 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 0 minecraft:redstone_block

# [432:0] Force unload chunk for the grid
forceload remove 400 0 480 48


# [480:0] Start Point 480 31 0 / End Point 528 79 48
# [480:0] Force load chunk for the grid
forceload add 448 0 528 48

# [480:0] left
setblock 480 31 16 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 16 minecraft:redstone_block

# [480:0] left (column 0)
setblock 480 31 -32 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 -32 minecraft:redstone_block

# [480:0] top
setblock 496 31 0 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 0 minecraft:redstone_block

# [480:0] Force unload chunk for the grid
forceload remove 448 0 528 48


# [0:48] Start Point 0 31 48 / End Point 48 79 96
# [0:48] Force load chunk for the grid
forceload add 0 16 48 96

# [0:48] left
setblock 0 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 64 minecraft:redstone_block

# [0:48] top
setblock 16 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 48 minecraft:redstone_block

# [0:48] top (row 0)
setblock -32 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 48 minecraft:redstone_block

# [0:48] Force unload chunk for the grid
forceload remove 0 16 48 96


# [48:48] Start Point 48 31 48 / End Point 96 79 96
# [48:48] Force load chunk for the grid
forceload add 48 48 96 96

# [48:48] left
setblock 48 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 64 minecraft:redstone_block

# [48:48] top
setblock 64 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 48 minecraft:redstone_block

# [48:48] Force unload chunk for the grid
forceload remove 48 48 96 96


# [96:48] Start Point 96 31 48 / End Point 144 79 96
# [96:48] Force load chunk for the grid
forceload add 96 48 144 96

# [96:48] left
setblock 96 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 64 minecraft:redstone_block

# [96:48] top
setblock 112 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 48 minecraft:redstone_block

# [96:48] Force unload chunk for the grid
forceload remove 96 48 144 96


# [144:48] Start Point 144 31 48 / End Point 192 79 96
# [144:48] Force load chunk for the grid
forceload add 144 48 192 96

# [144:48] left
setblock 144 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 64 minecraft:redstone_block

# [144:48] top
setblock 160 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 48 minecraft:redstone_block

# [144:48] Force unload chunk for the grid
forceload remove 144 48 192 96


# [192:48] Start Point 192 31 48 / End Point 240 79 96
# [192:48] Force load chunk for the grid
forceload add 192 48 240 96

# [192:48] left
setblock 192 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 64 minecraft:redstone_block

# [192:48] top
setblock 208 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 48 minecraft:redstone_block

# [192:48] Force unload chunk for the grid
forceload remove 192 48 240 96


# [240:48] Start Point 240 31 48 / End Point 288 79 96
# [240:48] Force load chunk for the grid
forceload add 240 48 288 96

# [240:48] left
setblock 240 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 64 minecraft:redstone_block

# [240:48] top
setblock 256 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 48 minecraft:redstone_block

# [240:48] Force unload chunk for the grid
forceload remove 240 48 288 96


# [288:48] Start Point 288 31 48 / End Point 336 79 96
# [288:48] Force load chunk for the grid
forceload add 288 48 336 96

# [288:48] left
setblock 288 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 64 minecraft:redstone_block

# [288:48] top
setblock 304 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 48 minecraft:redstone_block

# [288:48] Force unload chunk for the grid
forceload remove 288 48 336 96


# [336:48] Start Point 336 31 48 / End Point 384 79 96
# [336:48] Force load chunk for the grid
forceload add 336 48 384 96

# [336:48] left
setblock 336 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 64 minecraft:redstone_block

# [336:48] top
setblock 352 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 48 minecraft:redstone_block

# [336:48] Force unload chunk for the grid
forceload remove 336 48 384 96


# [384:48] Start Point 384 31 48 / End Point 432 79 96
# [384:48] Force load chunk for the grid
forceload add 384 48 432 96

# [384:48] left
setblock 384 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 64 minecraft:redstone_block

# [384:48] top
setblock 400 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 48 minecraft:redstone_block

# [384:48] Force unload chunk for the grid
forceload remove 384 48 432 96


# [432:48] Start Point 432 31 48 / End Point 480 79 96
# [432:48] Force load chunk for the grid
forceload add 432 48 480 96

# [432:48] left
setblock 432 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 64 minecraft:redstone_block

# [432:48] top
setblock 448 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 48 minecraft:redstone_block

# [432:48] Force unload chunk for the grid
forceload remove 432 48 480 96


# [480:48] Start Point 480 31 48 / End Point 528 79 96
# [480:48] Force load chunk for the grid
forceload add 480 48 528 96

# [480:48] left
setblock 480 31 64 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 64 minecraft:redstone_block

# [480:48] top
setblock 496 31 48 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 48 minecraft:redstone_block

# [480:48] Force unload chunk for the grid
forceload remove 480 48 528 96


# [0:96] Start Point 0 31 96 / End Point 48 79 144
# [0:96] Force load chunk for the grid
forceload add 0 64 48 144

# [0:96] left
setblock 0 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 112 minecraft:redstone_block

# [0:96] top
setblock 16 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 96 minecraft:redstone_block

# [0:96] top (row 0)
setblock -32 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 96 minecraft:redstone_block

# [0:96] Force unload chunk for the grid
forceload remove 0 64 48 144


# [48:96] Start Point 48 31 96 / End Point 96 79 144
# [48:96] Force load chunk for the grid
forceload add 48 96 96 144

# [48:96] left
setblock 48 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 112 minecraft:redstone_block

# [48:96] top
setblock 64 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 96 minecraft:redstone_block

# [48:96] Force unload chunk for the grid
forceload remove 48 96 96 144


# [96:96] Start Point 96 31 96 / End Point 144 79 144
# [96:96] Force load chunk for the grid
forceload add 96 96 144 144

# [96:96] left
setblock 96 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 112 minecraft:redstone_block

# [96:96] top
setblock 112 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 96 minecraft:redstone_block

# [96:96] Force unload chunk for the grid
forceload remove 96 96 144 144


# [144:96] Start Point 144 31 96 / End Point 192 79 144
# [144:96] Force load chunk for the grid
forceload add 144 96 192 144

# [144:96] left
setblock 144 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 112 minecraft:redstone_block

# [144:96] top
setblock 160 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 96 minecraft:redstone_block

# [144:96] Force unload chunk for the grid
forceload remove 144 96 192 144


# [192:96] Start Point 192 31 96 / End Point 240 79 144
# [192:96] Force load chunk for the grid
forceload add 192 96 240 144

# [192:96] left
setblock 192 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 112 minecraft:redstone_block

# [192:96] top
setblock 208 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 96 minecraft:redstone_block

# [192:96] Force unload chunk for the grid
forceload remove 192 96 240 144


# [240:96] Start Point 240 31 96 / End Point 288 79 144
# [240:96] Force load chunk for the grid
forceload add 240 96 288 144

# [240:96] left
setblock 240 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 112 minecraft:redstone_block

# [240:96] top
setblock 256 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 96 minecraft:redstone_block

# [240:96] Force unload chunk for the grid
forceload remove 240 96 288 144


# [288:96] Start Point 288 31 96 / End Point 336 79 144
# [288:96] Force load chunk for the grid
forceload add 288 96 336 144

# [288:96] left
setblock 288 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 112 minecraft:redstone_block

# [288:96] top
setblock 304 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 96 minecraft:redstone_block

# [288:96] Force unload chunk for the grid
forceload remove 288 96 336 144


# [336:96] Start Point 336 31 96 / End Point 384 79 144
# [336:96] Force load chunk for the grid
forceload add 336 96 384 144

# [336:96] left
setblock 336 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 112 minecraft:redstone_block

# [336:96] top
setblock 352 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 96 minecraft:redstone_block

# [336:96] Force unload chunk for the grid
forceload remove 336 96 384 144


# [384:96] Start Point 384 31 96 / End Point 432 79 144
# [384:96] Force load chunk for the grid
forceload add 384 96 432 144

# [384:96] left
setblock 384 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 112 minecraft:redstone_block

# [384:96] top
setblock 400 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 96 minecraft:redstone_block

# [384:96] Force unload chunk for the grid
forceload remove 384 96 432 144


# [432:96] Start Point 432 31 96 / End Point 480 79 144
# [432:96] Force load chunk for the grid
forceload add 432 96 480 144

# [432:96] left
setblock 432 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 112 minecraft:redstone_block

# [432:96] top
setblock 448 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 96 minecraft:redstone_block

# [432:96] Force unload chunk for the grid
forceload remove 432 96 480 144


# [480:96] Start Point 480 31 96 / End Point 528 79 144
# [480:96] Force load chunk for the grid
forceload add 480 96 528 144

# [480:96] left
setblock 480 31 112 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 112 minecraft:redstone_block

# [480:96] top
setblock 496 31 96 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 96 minecraft:redstone_block

# [480:96] Force unload chunk for the grid
forceload remove 480 96 528 144


# [0:144] Start Point 0 31 144 / End Point 48 79 192
# [0:144] Force load chunk for the grid
forceload add 0 112 48 192

# [0:144] left
setblock 0 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 160 minecraft:redstone_block

# [0:144] top
setblock 16 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 144 minecraft:redstone_block

# [0:144] top (row 0)
setblock -32 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 144 minecraft:redstone_block

# [0:144] Force unload chunk for the grid
forceload remove 0 112 48 192


# [48:144] Start Point 48 31 144 / End Point 96 79 192
# [48:144] Force load chunk for the grid
forceload add 48 144 96 192

# [48:144] left
setblock 48 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 160 minecraft:redstone_block

# [48:144] top
setblock 64 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 144 minecraft:redstone_block

# [48:144] Force unload chunk for the grid
forceload remove 48 144 96 192


# [96:144] Start Point 96 31 144 / End Point 144 79 192
# [96:144] Force load chunk for the grid
forceload add 96 144 144 192

# [96:144] left
setblock 96 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 160 minecraft:redstone_block

# [96:144] top
setblock 112 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 144 minecraft:redstone_block

# [96:144] Force unload chunk for the grid
forceload remove 96 144 144 192


# [144:144] Start Point 144 31 144 / End Point 192 79 192
# [144:144] Force load chunk for the grid
forceload add 144 144 192 192

# [144:144] left
setblock 144 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 160 minecraft:redstone_block

# [144:144] top
setblock 160 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 144 minecraft:redstone_block

# [144:144] Force unload chunk for the grid
forceload remove 144 144 192 192


# [192:144] Start Point 192 31 144 / End Point 240 79 192
# [192:144] Force load chunk for the grid
forceload add 192 144 240 192

# [192:144] left
setblock 192 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 160 minecraft:redstone_block

# [192:144] top
setblock 208 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 144 minecraft:redstone_block

# [192:144] Force unload chunk for the grid
forceload remove 192 144 240 192


# [240:144] Start Point 240 31 144 / End Point 288 79 192
# [240:144] Force load chunk for the grid
forceload add 240 144 288 192

# [240:144] left
setblock 240 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 160 minecraft:redstone_block

# [240:144] top
setblock 256 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 144 minecraft:redstone_block

# [240:144] Force unload chunk for the grid
forceload remove 240 144 288 192


# [288:144] Start Point 288 31 144 / End Point 336 79 192
# [288:144] Force load chunk for the grid
forceload add 288 144 336 192

# [288:144] left
setblock 288 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 160 minecraft:redstone_block

# [288:144] top
setblock 304 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 144 minecraft:redstone_block

# [288:144] Force unload chunk for the grid
forceload remove 288 144 336 192


# [336:144] Start Point 336 31 144 / End Point 384 79 192
# [336:144] Force load chunk for the grid
forceload add 336 144 384 192

# [336:144] left
setblock 336 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 160 minecraft:redstone_block

# [336:144] top
setblock 352 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 144 minecraft:redstone_block

# [336:144] Force unload chunk for the grid
forceload remove 336 144 384 192


# [384:144] Start Point 384 31 144 / End Point 432 79 192
# [384:144] Force load chunk for the grid
forceload add 384 144 432 192

# [384:144] left
setblock 384 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 160 minecraft:redstone_block

# [384:144] top
setblock 400 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 144 minecraft:redstone_block

# [384:144] Force unload chunk for the grid
forceload remove 384 144 432 192


# [432:144] Start Point 432 31 144 / End Point 480 79 192
# [432:144] Force load chunk for the grid
forceload add 432 144 480 192

# [432:144] left
setblock 432 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 160 minecraft:redstone_block

# [432:144] top
setblock 448 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 144 minecraft:redstone_block

# [432:144] Force unload chunk for the grid
forceload remove 432 144 480 192


# [480:144] Start Point 480 31 144 / End Point 528 79 192
# [480:144] Force load chunk for the grid
forceload add 480 144 528 192

# [480:144] left
setblock 480 31 160 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 160 minecraft:redstone_block

# [480:144] top
setblock 496 31 144 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 144 minecraft:redstone_block

# [480:144] Force unload chunk for the grid
forceload remove 480 144 528 192


# [0:192] Start Point 0 31 192 / End Point 48 79 240
# [0:192] Force load chunk for the grid
forceload add 0 160 48 240

# [0:192] left
setblock 0 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 208 minecraft:redstone_block

# [0:192] top
setblock 16 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 192 minecraft:redstone_block

# [0:192] top (row 0)
setblock -32 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 192 minecraft:redstone_block

# [0:192] Force unload chunk for the grid
forceload remove 0 160 48 240


# [48:192] Start Point 48 31 192 / End Point 96 79 240
# [48:192] Force load chunk for the grid
forceload add 48 192 96 240

# [48:192] left
setblock 48 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 208 minecraft:redstone_block

# [48:192] top
setblock 64 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 192 minecraft:redstone_block

# [48:192] Force unload chunk for the grid
forceload remove 48 192 96 240


# [96:192] Start Point 96 31 192 / End Point 144 79 240
# [96:192] Force load chunk for the grid
forceload add 96 192 144 240

# [96:192] left
setblock 96 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 208 minecraft:redstone_block

# [96:192] top
setblock 112 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 192 minecraft:redstone_block

# [96:192] Force unload chunk for the grid
forceload remove 96 192 144 240


# [144:192] Start Point 144 31 192 / End Point 192 79 240
# [144:192] Force load chunk for the grid
forceload add 144 192 192 240

# [144:192] left
setblock 144 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 208 minecraft:redstone_block

# [144:192] top
setblock 160 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 192 minecraft:redstone_block

# [144:192] Force unload chunk for the grid
forceload remove 144 192 192 240


# [192:192] Start Point 192 31 192 / End Point 240 79 240
# [192:192] Force load chunk for the grid
forceload add 192 192 240 240

# [192:192] left
setblock 192 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 208 minecraft:redstone_block

# [192:192] top
setblock 208 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 192 minecraft:redstone_block

# [192:192] Force unload chunk for the grid
forceload remove 192 192 240 240


# [240:192] Start Point 240 31 192 / End Point 288 79 240
# [240:192] Force load chunk for the grid
forceload add 240 192 288 240

# [240:192] left
setblock 240 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 208 minecraft:redstone_block

# [240:192] top
setblock 256 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 192 minecraft:redstone_block

# [240:192] Force unload chunk for the grid
forceload remove 240 192 288 240


# [288:192] Start Point 288 31 192 / End Point 336 79 240
# [288:192] Force load chunk for the grid
forceload add 288 192 336 240

# [288:192] left
setblock 288 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 208 minecraft:redstone_block

# [288:192] top
setblock 304 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 192 minecraft:redstone_block

# [288:192] Force unload chunk for the grid
forceload remove 288 192 336 240


# [336:192] Start Point 336 31 192 / End Point 384 79 240
# [336:192] Force load chunk for the grid
forceload add 336 192 384 240

# [336:192] left
setblock 336 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 208 minecraft:redstone_block

# [336:192] top
setblock 352 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 192 minecraft:redstone_block

# [336:192] Force unload chunk for the grid
forceload remove 336 192 384 240


# [384:192] Start Point 384 31 192 / End Point 432 79 240
# [384:192] Force load chunk for the grid
forceload add 384 192 432 240

# [384:192] left
setblock 384 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 208 minecraft:redstone_block

# [384:192] top
setblock 400 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 192 minecraft:redstone_block

# [384:192] Force unload chunk for the grid
forceload remove 384 192 432 240


# [432:192] Start Point 432 31 192 / End Point 480 79 240
# [432:192] Force load chunk for the grid
forceload add 432 192 480 240

# [432:192] left
setblock 432 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 208 minecraft:redstone_block

# [432:192] top
setblock 448 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 192 minecraft:redstone_block

# [432:192] Force unload chunk for the grid
forceload remove 432 192 480 240


# [480:192] Start Point 480 31 192 / End Point 528 79 240
# [480:192] Force load chunk for the grid
forceload add 480 192 528 240

# [480:192] left
setblock 480 31 208 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 208 minecraft:redstone_block

# [480:192] top
setblock 496 31 192 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 192 minecraft:redstone_block

# [480:192] Force unload chunk for the grid
forceload remove 480 192 528 240


# [0:240] Start Point 0 31 240 / End Point 48 79 288
# [0:240] Force load chunk for the grid
forceload add 0 208 48 288

# [0:240] left
setblock 0 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 256 minecraft:redstone_block

# [0:240] top
setblock 16 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 240 minecraft:redstone_block

# [0:240] top (row 0)
setblock -32 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 240 minecraft:redstone_block

# [0:240] Force unload chunk for the grid
forceload remove 0 208 48 288


# [48:240] Start Point 48 31 240 / End Point 96 79 288
# [48:240] Force load chunk for the grid
forceload add 48 240 96 288

# [48:240] left
setblock 48 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 256 minecraft:redstone_block

# [48:240] top
setblock 64 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 240 minecraft:redstone_block

# [48:240] Force unload chunk for the grid
forceload remove 48 240 96 288


# [96:240] Start Point 96 31 240 / End Point 144 79 288
# [96:240] Force load chunk for the grid
forceload add 96 240 144 288

# [96:240] left
setblock 96 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 256 minecraft:redstone_block

# [96:240] top
setblock 112 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 240 minecraft:redstone_block

# [96:240] Force unload chunk for the grid
forceload remove 96 240 144 288


# [144:240] Start Point 144 31 240 / End Point 192 79 288
# [144:240] Force load chunk for the grid
forceload add 144 240 192 288

# [144:240] left
setblock 144 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 256 minecraft:redstone_block

# [144:240] top
setblock 160 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 240 minecraft:redstone_block

# [144:240] Force unload chunk for the grid
forceload remove 144 240 192 288


# [192:240] Start Point 192 31 240 / End Point 240 79 288
# [192:240] Force load chunk for the grid
forceload add 192 240 240 288

# [192:240] left
setblock 192 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 256 minecraft:redstone_block

# [192:240] top
setblock 208 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 240 minecraft:redstone_block

# [192:240] Force unload chunk for the grid
forceload remove 192 240 240 288


# [240:240] Start Point 240 31 240 / End Point 288 79 288
# [240:240] Force load chunk for the grid
forceload add 240 240 288 288

# [240:240] left
setblock 240 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 256 minecraft:redstone_block

# [240:240] top
setblock 256 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 240 minecraft:redstone_block

# [240:240] Force unload chunk for the grid
forceload remove 240 240 288 288


# [288:240] Start Point 288 31 240 / End Point 336 79 288
# [288:240] Force load chunk for the grid
forceload add 288 240 336 288

# [288:240] left
setblock 288 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 256 minecraft:redstone_block

# [288:240] top
setblock 304 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 240 minecraft:redstone_block

# [288:240] Force unload chunk for the grid
forceload remove 288 240 336 288


# [336:240] Start Point 336 31 240 / End Point 384 79 288
# [336:240] Force load chunk for the grid
forceload add 336 240 384 288

# [336:240] left
setblock 336 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 256 minecraft:redstone_block

# [336:240] top
setblock 352 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 240 minecraft:redstone_block

# [336:240] Force unload chunk for the grid
forceload remove 336 240 384 288


# [384:240] Start Point 384 31 240 / End Point 432 79 288
# [384:240] Force load chunk for the grid
forceload add 384 240 432 288

# [384:240] left
setblock 384 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 256 minecraft:redstone_block

# [384:240] top
setblock 400 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 240 minecraft:redstone_block

# [384:240] Force unload chunk for the grid
forceload remove 384 240 432 288


# [432:240] Start Point 432 31 240 / End Point 480 79 288
# [432:240] Force load chunk for the grid
forceload add 432 240 480 288

# [432:240] left
setblock 432 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 256 minecraft:redstone_block

# [432:240] top
setblock 448 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 240 minecraft:redstone_block

# [432:240] Force unload chunk for the grid
forceload remove 432 240 480 288


# [480:240] Start Point 480 31 240 / End Point 528 79 288
# [480:240] Force load chunk for the grid
forceload add 480 240 528 288

# [480:240] left
setblock 480 31 256 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 256 minecraft:redstone_block

# [480:240] top
setblock 496 31 240 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 240 minecraft:redstone_block

# [480:240] Force unload chunk for the grid
forceload remove 480 240 528 288


# [0:288] Start Point 0 31 288 / End Point 48 79 336
# [0:288] Force load chunk for the grid
forceload add 0 256 48 336

# [0:288] left
setblock 0 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 304 minecraft:redstone_block

# [0:288] top
setblock 16 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 288 minecraft:redstone_block

# [0:288] top (row 0)
setblock -32 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 288 minecraft:redstone_block

# [0:288] Force unload chunk for the grid
forceload remove 0 256 48 336


# [48:288] Start Point 48 31 288 / End Point 96 79 336
# [48:288] Force load chunk for the grid
forceload add 48 288 96 336

# [48:288] left
setblock 48 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 304 minecraft:redstone_block

# [48:288] top
setblock 64 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 288 minecraft:redstone_block

# [48:288] Force unload chunk for the grid
forceload remove 48 288 96 336


# [96:288] Start Point 96 31 288 / End Point 144 79 336
# [96:288] Force load chunk for the grid
forceload add 96 288 144 336

# [96:288] left
setblock 96 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 304 minecraft:redstone_block

# [96:288] top
setblock 112 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 288 minecraft:redstone_block

# [96:288] Force unload chunk for the grid
forceload remove 96 288 144 336


# [144:288] Start Point 144 31 288 / End Point 192 79 336
# [144:288] Force load chunk for the grid
forceload add 144 288 192 336

# [144:288] left
setblock 144 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 304 minecraft:redstone_block

# [144:288] top
setblock 160 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 288 minecraft:redstone_block

# [144:288] Force unload chunk for the grid
forceload remove 144 288 192 336


# [192:288] Start Point 192 31 288 / End Point 240 79 336
# [192:288] Force load chunk for the grid
forceload add 192 288 240 336

# [192:288] left
setblock 192 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 304 minecraft:redstone_block

# [192:288] top
setblock 208 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 288 minecraft:redstone_block

# [192:288] Force unload chunk for the grid
forceload remove 192 288 240 336


# [240:288] Start Point 240 31 288 / End Point 288 79 336
# [240:288] Force load chunk for the grid
forceload add 240 288 288 336

# [240:288] left
setblock 240 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 304 minecraft:redstone_block

# [240:288] top
setblock 256 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 288 minecraft:redstone_block

# [240:288] Force unload chunk for the grid
forceload remove 240 288 288 336


# [288:288] Start Point 288 31 288 / End Point 336 79 336
# [288:288] Force load chunk for the grid
forceload add 288 288 336 336

# [288:288] left
setblock 288 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 304 minecraft:redstone_block

# [288:288] top
setblock 304 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 288 minecraft:redstone_block

# [288:288] Force unload chunk for the grid
forceload remove 288 288 336 336


# [336:288] Start Point 336 31 288 / End Point 384 79 336
# [336:288] Force load chunk for the grid
forceload add 336 288 384 336

# [336:288] left
setblock 336 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 304 minecraft:redstone_block

# [336:288] top
setblock 352 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 288 minecraft:redstone_block

# [336:288] Force unload chunk for the grid
forceload remove 336 288 384 336


# [384:288] Start Point 384 31 288 / End Point 432 79 336
# [384:288] Force load chunk for the grid
forceload add 384 288 432 336

# [384:288] left
setblock 384 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 304 minecraft:redstone_block

# [384:288] top
setblock 400 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 288 minecraft:redstone_block

# [384:288] Force unload chunk for the grid
forceload remove 384 288 432 336


# [432:288] Start Point 432 31 288 / End Point 480 79 336
# [432:288] Force load chunk for the grid
forceload add 432 288 480 336

# [432:288] left
setblock 432 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 304 minecraft:redstone_block

# [432:288] top
setblock 448 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 288 minecraft:redstone_block

# [432:288] Force unload chunk for the grid
forceload remove 432 288 480 336


# [480:288] Start Point 480 31 288 / End Point 528 79 336
# [480:288] Force load chunk for the grid
forceload add 480 288 528 336

# [480:288] left
setblock 480 31 304 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 304 minecraft:redstone_block

# [480:288] top
setblock 496 31 288 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 288 minecraft:redstone_block

# [480:288] Force unload chunk for the grid
forceload remove 480 288 528 336


# [0:336] Start Point 0 31 336 / End Point 48 79 384
# [0:336] Force load chunk for the grid
forceload add 0 304 48 384

# [0:336] left
setblock 0 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 352 minecraft:redstone_block

# [0:336] top
setblock 16 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 336 minecraft:redstone_block

# [0:336] top (row 0)
setblock -32 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 336 minecraft:redstone_block

# [0:336] Force unload chunk for the grid
forceload remove 0 304 48 384


# [48:336] Start Point 48 31 336 / End Point 96 79 384
# [48:336] Force load chunk for the grid
forceload add 48 336 96 384

# [48:336] left
setblock 48 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 352 minecraft:redstone_block

# [48:336] top
setblock 64 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 336 minecraft:redstone_block

# [48:336] Force unload chunk for the grid
forceload remove 48 336 96 384


# [96:336] Start Point 96 31 336 / End Point 144 79 384
# [96:336] Force load chunk for the grid
forceload add 96 336 144 384

# [96:336] left
setblock 96 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 352 minecraft:redstone_block

# [96:336] top
setblock 112 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 336 minecraft:redstone_block

# [96:336] Force unload chunk for the grid
forceload remove 96 336 144 384


# [144:336] Start Point 144 31 336 / End Point 192 79 384
# [144:336] Force load chunk for the grid
forceload add 144 336 192 384

# [144:336] left
setblock 144 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 352 minecraft:redstone_block

# [144:336] top
setblock 160 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 336 minecraft:redstone_block

# [144:336] Force unload chunk for the grid
forceload remove 144 336 192 384


# [192:336] Start Point 192 31 336 / End Point 240 79 384
# [192:336] Force load chunk for the grid
forceload add 192 336 240 384

# [192:336] left
setblock 192 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 352 minecraft:redstone_block

# [192:336] top
setblock 208 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 336 minecraft:redstone_block

# [192:336] Force unload chunk for the grid
forceload remove 192 336 240 384


# [240:336] Start Point 240 31 336 / End Point 288 79 384
# [240:336] Force load chunk for the grid
forceload add 240 336 288 384

# [240:336] left
setblock 240 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 352 minecraft:redstone_block

# [240:336] top
setblock 256 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 336 minecraft:redstone_block

# [240:336] Force unload chunk for the grid
forceload remove 240 336 288 384


# [288:336] Start Point 288 31 336 / End Point 336 79 384
# [288:336] Force load chunk for the grid
forceload add 288 336 336 384

# [288:336] left
setblock 288 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 352 minecraft:redstone_block

# [288:336] top
setblock 304 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 336 minecraft:redstone_block

# [288:336] Force unload chunk for the grid
forceload remove 288 336 336 384


# [336:336] Start Point 336 31 336 / End Point 384 79 384
# [336:336] Force load chunk for the grid
forceload add 336 336 384 384

# [336:336] left
setblock 336 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 352 minecraft:redstone_block

# [336:336] top
setblock 352 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 336 minecraft:redstone_block

# [336:336] Force unload chunk for the grid
forceload remove 336 336 384 384


# [384:336] Start Point 384 31 336 / End Point 432 79 384
# [384:336] Force load chunk for the grid
forceload add 384 336 432 384

# [384:336] left
setblock 384 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 352 minecraft:redstone_block

# [384:336] top
setblock 400 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 336 minecraft:redstone_block

# [384:336] Force unload chunk for the grid
forceload remove 384 336 432 384


# [432:336] Start Point 432 31 336 / End Point 480 79 384
# [432:336] Force load chunk for the grid
forceload add 432 336 480 384

# [432:336] left
setblock 432 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 352 minecraft:redstone_block

# [432:336] top
setblock 448 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 336 minecraft:redstone_block

# [432:336] Force unload chunk for the grid
forceload remove 432 336 480 384


# [480:336] Start Point 480 31 336 / End Point 528 79 384
# [480:336] Force load chunk for the grid
forceload add 480 336 528 384

# [480:336] left
setblock 480 31 352 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 352 minecraft:redstone_block

# [480:336] top
setblock 496 31 336 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 336 minecraft:redstone_block

# [480:336] Force unload chunk for the grid
forceload remove 480 336 528 384


# [0:384] Start Point 0 31 384 / End Point 48 79 432
# [0:384] Force load chunk for the grid
forceload add 0 352 48 432

# [0:384] left
setblock 0 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 400 minecraft:redstone_block

# [0:384] top
setblock 16 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 384 minecraft:redstone_block

# [0:384] top (row 0)
setblock -32 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 384 minecraft:redstone_block

# [0:384] Force unload chunk for the grid
forceload remove 0 352 48 432


# [48:384] Start Point 48 31 384 / End Point 96 79 432
# [48:384] Force load chunk for the grid
forceload add 48 384 96 432

# [48:384] left
setblock 48 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 400 minecraft:redstone_block

# [48:384] top
setblock 64 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 384 minecraft:redstone_block

# [48:384] Force unload chunk for the grid
forceload remove 48 384 96 432


# [96:384] Start Point 96 31 384 / End Point 144 79 432
# [96:384] Force load chunk for the grid
forceload add 96 384 144 432

# [96:384] left
setblock 96 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 400 minecraft:redstone_block

# [96:384] top
setblock 112 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 384 minecraft:redstone_block

# [96:384] Force unload chunk for the grid
forceload remove 96 384 144 432


# [144:384] Start Point 144 31 384 / End Point 192 79 432
# [144:384] Force load chunk for the grid
forceload add 144 384 192 432

# [144:384] left
setblock 144 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 400 minecraft:redstone_block

# [144:384] top
setblock 160 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 384 minecraft:redstone_block

# [144:384] Force unload chunk for the grid
forceload remove 144 384 192 432


# [192:384] Start Point 192 31 384 / End Point 240 79 432
# [192:384] Force load chunk for the grid
forceload add 192 384 240 432

# [192:384] left
setblock 192 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 400 minecraft:redstone_block

# [192:384] top
setblock 208 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 384 minecraft:redstone_block

# [192:384] Force unload chunk for the grid
forceload remove 192 384 240 432


# [240:384] Start Point 240 31 384 / End Point 288 79 432
# [240:384] Force load chunk for the grid
forceload add 240 384 288 432

# [240:384] left
setblock 240 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 400 minecraft:redstone_block

# [240:384] top
setblock 256 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 384 minecraft:redstone_block

# [240:384] Force unload chunk for the grid
forceload remove 240 384 288 432


# [288:384] Start Point 288 31 384 / End Point 336 79 432
# [288:384] Force load chunk for the grid
forceload add 288 384 336 432

# [288:384] left
setblock 288 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 400 minecraft:redstone_block

# [288:384] top
setblock 304 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 384 minecraft:redstone_block

# [288:384] Force unload chunk for the grid
forceload remove 288 384 336 432


# [336:384] Start Point 336 31 384 / End Point 384 79 432
# [336:384] Force load chunk for the grid
forceload add 336 384 384 432

# [336:384] left
setblock 336 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 400 minecraft:redstone_block

# [336:384] top
setblock 352 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 384 minecraft:redstone_block

# [336:384] Force unload chunk for the grid
forceload remove 336 384 384 432


# [384:384] Start Point 384 31 384 / End Point 432 79 432
# [384:384] Force load chunk for the grid
forceload add 384 384 432 432

# [384:384] left
setblock 384 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 400 minecraft:redstone_block

# [384:384] top
setblock 400 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 384 minecraft:redstone_block

# [384:384] Force unload chunk for the grid
forceload remove 384 384 432 432


# [432:384] Start Point 432 31 384 / End Point 480 79 432
# [432:384] Force load chunk for the grid
forceload add 432 384 480 432

# [432:384] left
setblock 432 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 400 minecraft:redstone_block

# [432:384] top
setblock 448 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 384 minecraft:redstone_block

# [432:384] Force unload chunk for the grid
forceload remove 432 384 480 432


# [480:384] Start Point 480 31 384 / End Point 528 79 432
# [480:384] Force load chunk for the grid
forceload add 480 384 528 432

# [480:384] left
setblock 480 31 400 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 400 minecraft:redstone_block

# [480:384] top
setblock 496 31 384 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 384 minecraft:redstone_block

# [480:384] Force unload chunk for the grid
forceload remove 480 384 528 432


# [0:432] Start Point 0 31 432 / End Point 48 79 480
# [0:432] Force load chunk for the grid
forceload add 0 400 48 480

# [0:432] left
setblock 0 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 448 minecraft:redstone_block

# [0:432] top
setblock 16 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 432 minecraft:redstone_block

# [0:432] top (row 0)
setblock -32 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 432 minecraft:redstone_block

# [0:432] Force unload chunk for the grid
forceload remove 0 400 48 480


# [48:432] Start Point 48 31 432 / End Point 96 79 480
# [48:432] Force load chunk for the grid
forceload add 48 432 96 480

# [48:432] left
setblock 48 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 448 minecraft:redstone_block

# [48:432] top
setblock 64 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 432 minecraft:redstone_block

# [48:432] Force unload chunk for the grid
forceload remove 48 432 96 480


# [96:432] Start Point 96 31 432 / End Point 144 79 480
# [96:432] Force load chunk for the grid
forceload add 96 432 144 480

# [96:432] left
setblock 96 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 448 minecraft:redstone_block

# [96:432] top
setblock 112 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 432 minecraft:redstone_block

# [96:432] Force unload chunk for the grid
forceload remove 96 432 144 480


# [144:432] Start Point 144 31 432 / End Point 192 79 480
# [144:432] Force load chunk for the grid
forceload add 144 432 192 480

# [144:432] left
setblock 144 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 448 minecraft:redstone_block

# [144:432] top
setblock 160 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 432 minecraft:redstone_block

# [144:432] Force unload chunk for the grid
forceload remove 144 432 192 480


# [192:432] Start Point 192 31 432 / End Point 240 79 480
# [192:432] Force load chunk for the grid
forceload add 192 432 240 480

# [192:432] left
setblock 192 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 448 minecraft:redstone_block

# [192:432] top
setblock 208 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 432 minecraft:redstone_block

# [192:432] Force unload chunk for the grid
forceload remove 192 432 240 480


# [240:432] Start Point 240 31 432 / End Point 288 79 480
# [240:432] Force load chunk for the grid
forceload add 240 432 288 480

# [240:432] left
setblock 240 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 448 minecraft:redstone_block

# [240:432] top
setblock 256 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 432 minecraft:redstone_block

# [240:432] Force unload chunk for the grid
forceload remove 240 432 288 480


# [288:432] Start Point 288 31 432 / End Point 336 79 480
# [288:432] Force load chunk for the grid
forceload add 288 432 336 480

# [288:432] left
setblock 288 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 448 minecraft:redstone_block

# [288:432] top
setblock 304 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 432 minecraft:redstone_block

# [288:432] Force unload chunk for the grid
forceload remove 288 432 336 480


# [336:432] Start Point 336 31 432 / End Point 384 79 480
# [336:432] Force load chunk for the grid
forceload add 336 432 384 480

# [336:432] left
setblock 336 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 448 minecraft:redstone_block

# [336:432] top
setblock 352 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 432 minecraft:redstone_block

# [336:432] Force unload chunk for the grid
forceload remove 336 432 384 480


# [384:432] Start Point 384 31 432 / End Point 432 79 480
# [384:432] Force load chunk for the grid
forceload add 384 432 432 480

# [384:432] left
setblock 384 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 448 minecraft:redstone_block

# [384:432] top
setblock 400 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 432 minecraft:redstone_block

# [384:432] Force unload chunk for the grid
forceload remove 384 432 432 480


# [432:432] Start Point 432 31 432 / End Point 480 79 480
# [432:432] Force load chunk for the grid
forceload add 432 432 480 480

# [432:432] left
setblock 432 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 448 minecraft:redstone_block

# [432:432] top
setblock 448 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 432 minecraft:redstone_block

# [432:432] Force unload chunk for the grid
forceload remove 432 432 480 480


# [480:432] Start Point 480 31 432 / End Point 528 79 480
# [480:432] Force load chunk for the grid
forceload add 480 432 528 480

# [480:432] left
setblock 480 31 448 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 448 minecraft:redstone_block

# [480:432] top
setblock 496 31 432 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 432 minecraft:redstone_block

# [480:432] Force unload chunk for the grid
forceload remove 480 432 528 480


# [0:480] Start Point 0 31 480 / End Point 48 79 528
# [0:480] Force load chunk for the grid
forceload add 0 448 48 528

# [0:480] left
setblock 0 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 0 32 496 minecraft:redstone_block

# [0:480] top
setblock 16 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 16 32 480 minecraft:redstone_block

# [0:480] top (row 0)
setblock -32 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock -32 32 480 minecraft:redstone_block

# [0:480] Force unload chunk for the grid
forceload remove 0 448 48 528


# [48:480] Start Point 48 31 480 / End Point 96 79 528
# [48:480] Force load chunk for the grid
forceload add 48 480 96 528

# [48:480] left
setblock 48 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 48 32 496 minecraft:redstone_block

# [48:480] top
setblock 64 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 64 32 480 minecraft:redstone_block

# [48:480] Force unload chunk for the grid
forceload remove 48 480 96 528


# [96:480] Start Point 96 31 480 / End Point 144 79 528
# [96:480] Force load chunk for the grid
forceload add 96 480 144 528

# [96:480] left
setblock 96 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 96 32 496 minecraft:redstone_block

# [96:480] top
setblock 112 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 112 32 480 minecraft:redstone_block

# [96:480] Force unload chunk for the grid
forceload remove 96 480 144 528


# [144:480] Start Point 144 31 480 / End Point 192 79 528
# [144:480] Force load chunk for the grid
forceload add 144 480 192 528

# [144:480] left
setblock 144 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 144 32 496 minecraft:redstone_block

# [144:480] top
setblock 160 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 160 32 480 minecraft:redstone_block

# [144:480] Force unload chunk for the grid
forceload remove 144 480 192 528


# [192:480] Start Point 192 31 480 / End Point 240 79 528
# [192:480] Force load chunk for the grid
forceload add 192 480 240 528

# [192:480] left
setblock 192 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 192 32 496 minecraft:redstone_block

# [192:480] top
setblock 208 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 208 32 480 minecraft:redstone_block

# [192:480] Force unload chunk for the grid
forceload remove 192 480 240 528


# [240:480] Start Point 240 31 480 / End Point 288 79 528
# [240:480] Force load chunk for the grid
forceload add 240 480 288 528

# [240:480] left
setblock 240 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 240 32 496 minecraft:redstone_block

# [240:480] top
setblock 256 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 256 32 480 minecraft:redstone_block

# [240:480] Force unload chunk for the grid
forceload remove 240 480 288 528


# [288:480] Start Point 288 31 480 / End Point 336 79 528
# [288:480] Force load chunk for the grid
forceload add 288 480 336 528

# [288:480] left
setblock 288 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 288 32 496 minecraft:redstone_block

# [288:480] top
setblock 304 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 304 32 480 minecraft:redstone_block

# [288:480] Force unload chunk for the grid
forceload remove 288 480 336 528


# [336:480] Start Point 336 31 480 / End Point 384 79 528
# [336:480] Force load chunk for the grid
forceload add 336 480 384 528

# [336:480] left
setblock 336 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 336 32 496 minecraft:redstone_block

# [336:480] top
setblock 352 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 352 32 480 minecraft:redstone_block

# [336:480] Force unload chunk for the grid
forceload remove 336 480 384 528


# [384:480] Start Point 384 31 480 / End Point 432 79 528
# [384:480] Force load chunk for the grid
forceload add 384 480 432 528

# [384:480] left
setblock 384 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 384 32 496 minecraft:redstone_block

# [384:480] top
setblock 400 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 400 32 480 minecraft:redstone_block

# [384:480] Force unload chunk for the grid
forceload remove 384 480 432 528


# [432:480] Start Point 432 31 480 / End Point 480 79 528
# [432:480] Force load chunk for the grid
forceload add 432 480 480 528

# [432:480] left
setblock 432 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 432 32 496 minecraft:redstone_block

# [432:480] top
setblock 448 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 448 32 480 minecraft:redstone_block

# [432:480] Force unload chunk for the grid
forceload remove 432 480 480 528


# [480:480] Start Point 480 31 480 / End Point 528 79 528
# [480:480] Force load chunk for the grid
forceload add 480 480 528 528

# [480:480] left
setblock 480 31 496 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock 480 32 496 minecraft:redstone_block

# [480:480] top
setblock 496 31 480 minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock 496 32 480 minecraft:redstone_block

# [480:480] Force unload chunk for the grid
forceload remove 480 480 528 528


# Remove force loaded chunks (just to be sure)
forceload remove all
