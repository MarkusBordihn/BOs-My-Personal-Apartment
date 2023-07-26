/**
 * Copyright 2023 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

// Settings
const gridWidth = 512;
const gridHeight = 512;
const gridSize = 16 * 3; // We have a 4x4 chunk but only need a 3x3 chunks for the pattern grid.
const result = [];

class GridGenerator {
  static gridY = 31;

  static generate(gridWidth = 64, gridHeight = 64, gridSize = 16) {
    if (gridWidth < gridSize || gridHeight < gridSize) {
      console.error(
        `Grid size ${gridSize} is not a multiple of grid width ${gridWidth} or grid height ${gridHeight}`
      );
      return;
    }

    const numberOfChunks = GridGenerator.getNumberOfChunks(
      gridWidth,
      gridHeight,
      gridSize
    );
    const gridStartXPoint = 0;
    const gridStartZPoint = 0;
    console.log(
      `Start generating grid for ${gridWidth}x${gridHeight} (${gridSize}) with start point ${gridStartXPoint},${GridGenerator.gridY},${gridStartZPoint} with ${numberOfChunks} chunks.`
    );

    for (let column = 0; column < gridHeight; column += gridSize) {
      for (let row = 0; row < gridWidth; row += gridSize) {
        const startXPoint = gridStartXPoint + row;
        const startZPoint = gridStartZPoint + column;
        GridGenerator.getGridBaseBlocks(
          startXPoint,
          GridGenerator.gridY,
          startZPoint,
          gridSize,
          row,
          column
        );
      }
    }

    console.log(`
# Remove force loaded chunks (just to be sure)
forceload remove all\n`);
  }

  static getGridBaseBlocks(x, y, z, gridSize, row, column) {
    // Calculate grid information.
    const rowColumnInfo = `[${row}:${column}]`;
    const startXPoint = x;
    const startYPoint = y;
    const startZPoint = z;
    const endXPoint = x + gridSize;
    const endYPoint = y + gridSize;
    const endZPoint = z + gridSize;
    const chunkStartXPoint = column == 0 ? startXPoint - 32 : startXPoint;
    const chunkStartZPoint = row == 0 ? startZPoint - 32 : startZPoint;
    const chunkEndXPoint = endXPoint;
    const chunkEndZPoint = endZPoint;

    // Process grid information and generate the commands.
    const gridInfo = `
# ${rowColumnInfo} Start Point ${startXPoint} ${startYPoint} ${startZPoint} / End Point ${endXPoint} ${endYPoint} ${endZPoint}`;

    // Force load chunk for the grid to avoid issues with the structure blocks.
    const forceLoad = `
# ${rowColumnInfo} Force load chunk for the grid
forceload add ${chunkStartXPoint} ${chunkStartZPoint} ${chunkEndXPoint} ${chunkEndZPoint}\n`;

    let rowLeft = `
# ${rowColumnInfo} left
setblock ${startXPoint} ${startYPoint} ${
      endZPoint - gridSize + 16
    } minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock ${startXPoint} ${startYPoint + 1} ${
      endZPoint - gridSize + 16
    } minecraft:redstone_block\n`;

    // Add additional left block for the first column to avoid unused space.
    if (column === 0) {
      rowLeft += `
# ${rowColumnInfo} left (column 0)
setblock ${startXPoint} ${startYPoint} ${
        endZPoint - gridSize * 2 + 16
      } minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/left_right_block"} replace
setblock ${startXPoint} ${startYPoint + 1} ${
        endZPoint - gridSize * 2 + 16
      } minecraft:redstone_block\n`;
    }

    let rowTop = `
# ${rowColumnInfo} top
setblock ${
      startXPoint + 16
    } ${startYPoint} ${startZPoint} minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock ${startXPoint + 16} ${
      startYPoint + 1
    } ${startZPoint} minecraft:redstone_block\n`;

    // Add additional top block for the first row to avoid unused space.
    if (row === 0) {
      rowTop += `
# ${rowColumnInfo} top (row 0)
setblock ${
        startXPoint - gridSize + 16
      } ${startYPoint} ${startZPoint} minecraft:structure_block{mode: "LOAD", name: "my_personal_apartment:base/top_bottom_block"} replace
setblock ${startXPoint - gridSize + 16} ${
        startYPoint + 1
      } ${startZPoint} minecraft:redstone_block\n`;
    }

    // Force unload chunk for the grid to avoid issues with the structure blocks.
    const forceUnload = `
# ${rowColumnInfo} Force unload chunk for the grid
forceload remove ${chunkStartXPoint} ${chunkStartZPoint} ${chunkEndXPoint} ${chunkEndZPoint}\n`;

    console.log(gridInfo, forceLoad, rowLeft, rowTop, forceUnload);
  }

  static getNumberOfChunks(width = 64, height = 64, chunkSize = 16) {
    const chunkCountWidth = Math.ceil(width / chunkSize);
    const chunkCountHeight = Math.ceil(height / chunkSize);
    const totalChunks = chunkCountWidth * chunkCountHeight;
    return totalChunks;
  }
}

GridGenerator.generate(gridWidth, gridHeight, gridSize);
