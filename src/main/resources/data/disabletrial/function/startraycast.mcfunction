tag @s add dt.cooldown
scoreboard players set @s dt.cooldown 20
execute unless score dt.adventure dt.adventure matches 1 if entity @s[gamemode=adventure] run return fail
execute if entity @s[tag=dt.nodisable] run return fail
execute store result score @s dt.hand run function disabletrial:get_hand
execute unless score @s dt.hand matches 1.. run return fail
#Here the restriction code part starts

#If you have biomes tagged in #disabletrial:nodisable (located disabletrial/tags/worldgen/biome, uncomment following line
#execute if biome #disabletrial:nodisable run return fail

#If you have a predicate disabletrial:nodisable defined in disabletrial/predicate, uncomment following line.
#execute if predicate disabletrial:nodisable run return fail

#If you want extra conditions, add the code for them here, ideally with execute ... run return fail


tag @s add dt.raycaster
#max length of raycast (via attribute to simulate vanilla behavior)
execute store result score @s dt.range run attribute @s minecraft:player.block_interaction_range get 10
scoreboard players operation dt.raycastLimit dt.raycast = @s dt.range
#call recursive raycastfunction
scoreboard players set @s dt.success 0
execute store result score @s dt.success at @s anchored eyes positioned ^ ^ ^.1 run function disabletrial:raycast
tag @s remove dt.raycaster
#If key used, check key -> specific function
execute unless score @s dt.success matches 1 run return fail
execute if entity @s[gamemode=creative] run return 100
scoreboard players set @s dt.handphase 0
execute if predicate disabletrial:key_level_copper run return run function disabletrial:item_damage/key_copper
execute if predicate disabletrial:key_level_diamond run return run function disabletrial:item_damage/key_diamond
execute if predicate disabletrial:key_level_netherite run return run function disabletrial:item_damage/key_netherite
scoreboard players set @s dt.handphase 1
execute if predicate disabletrial:key_level_copper run return run function disabletrial:item_damage/key_copper
execute if predicate disabletrial:key_level_diamond run return run function disabletrial:item_damage/key_diamond
execute if predicate disabletrial:key_level_netherite run return run function disabletrial:item_damage/key_netherite