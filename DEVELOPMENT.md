# My Personal Apartment - Development

## Teleport

### Teleport to My Personal Apartment dimension

To teleport to the My Personal Apartment dimension, you can use the following command:

```command
/execute in my_personal_apartment:apartments_dimension run tp @s ~ ~ ~
```

### Teleport to the overworld

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

## Design

### Design of the reception

The design of the reception is based on the vanilla design of villages.
In particular the following based structures are used as a rough reference.

#### Small reception

- minecraft:village/desert/houses/desert_small_house_4
- minecraft:village/plains/houses/plains_small_house_4
- minecraft:village/savanna/houses/savanna_small_house_4
- minecraft:village/snowy/houses/snowy_small_house_2
- minecraft:village/taiga/houses/taiga_small_house_1

#### Medium reception

- minecraft:village/desert/houses/desert_shepherd_house_1
- minecraft:village/plains/houses/plains_shepherds_house_1
- minecraft:village/savanna/houses/savanna_shepherd_1
- minecraft:village/snowy/houses/snowy_shepherds_house_1
- minecraft:village/taiga/houses/taiga_shepherds_house_1

#### Large reception

- minecraft:village/desert/houses/desert_temple_1
- minecraft:village/plains/houses/plains_medium_house_1
- minecraft:village/savanna/houses/savanna_medium_house_1
- minecraft:village/snowy/houses/snowy_masons_house_1
- minecraft:village/taiga/houses/taiga_medium_house_4

### Design of the apartment

The design of the apartments is not based on any vanilla structure.
