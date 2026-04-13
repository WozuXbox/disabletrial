scoreboard players add dt.max dt.count 1
scoreboard players operation dt.check dt.check = @s dt.displayid
execute as @s at @s run disabletrialmarkermigratetomodcommand_no_random_uuid_before
execute as @e[type=item_display,limit=1,sort=nearest,tag=dt,predicate=disabletrial:check] run kill @s
kill @s
return 100