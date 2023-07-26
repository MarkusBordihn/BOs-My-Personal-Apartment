# My Personal Apartment - Development

## Teleport

### Teleport to My Personal Apartment dimension

To teleport to the My Personal Apartment dimension, you can use the following command:

```command
/execute in my_personal_apartment:apartments_dimension run tp @s ~ ~ ~
```

### Teleport to overworld

To teleport to the overworld, you can use the following command:

```command
/execute in minecraft:overworld run tp @s ~ ~ ~
```

## Base Grid

The base grid has a size of 4 x 4 chunks. The start of the grid is at the coordinates (0, 0).
It is generated over a JavaScript file in the utils/ folder with the following command:

```command
npm run generator:base_grid
```
