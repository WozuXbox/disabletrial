execute store result score @s dt.id run scoreboard players add dt.max dt.max 1
execute store result score @s dt.displayid run scoreboard players add dt.max dt.max 1
summon item_display ~ ~ ~ {Tags:["dt","fresh","dt.display","dt.version1.21"],brightness:{sky:0,block:15},transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[1.2f,1.2f,1.2f]},item:{id:"minecraft:red_stained_glass",count:1}}
scoreboard players operation @n[type=item_display, tag=dt, tag=fresh, limit=1, sort=nearest, distance=0..0.00001] dt.id = @s dt.displayid
scoreboard players operation @n[type=item_display, tag=dt, tag=fresh, limit=1, sort=nearest, distance=0..0.00001] dt.markerid = @s dt.id
data modify block ~ ~ ~ cooldown_ends_at set value 9223372036854775807L
tag @s remove fresh
tag @n[type=item_display, tag=dt, tag=fresh, limit=1, sort=nearest, distance=0..0.00001] remove fresh
return 1