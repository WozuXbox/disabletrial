execute store result score @s dt.time run time query gametime
scoreboard players add @s dt.time 12000
execute store result entity @s data.time long 1 run scoreboard players get @s dt.time 
data modify block ~ ~ ~ cooldown_ends_at set from entity @s data.time
scoreboard players operation dt.check dt.check = @s dt.displayid
tellraw @a[tag=dt.debug] ["dt.check=",{"score":{"name":"dt.check","objective":"dt.check"}}]
tellraw @a[tag=dt.debug] ["dt.displayid=",{"score":{"name":"@s","objective":"dt.displayid"}}]
execute as @e[type=item_display,limit=1,sort=nearest,tag=dt,predicate=disabletrial:check] run kill @s
kill @s
return 100