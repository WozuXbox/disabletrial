scoreboard players remove dt.raycastLimit dt.raycast 1
execute if entity @a[tag=debug] run particle minecraft:flame
execute if block ~ ~ ~ minecraft:trial_spawner align xyz positioned ~0.5 ~0.5 ~0.5 run return run function disabletrial:found_spawner
execute if block ~ ~ ~ #minecraft:replaceable if score dt.raycastLimit dt.raycast matches 1.. positioned ^ ^ ^.1 run function disabletrial:raycast