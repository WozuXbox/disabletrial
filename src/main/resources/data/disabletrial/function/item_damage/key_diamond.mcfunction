#adding damage to the item via this very large item modifier
execute if score @s dt.hand matches 1 run item modify entity @s weapon.mainhand disabletrial:mainhand/damage_predicate10
execute if score @s dt.hand matches 2 run item modify entity @s weapon.offhand disabletrial:offhand/damage_predicate10
#breaking item if needed
execute unless predicate disabletrial:10broken run return 1
playsound minecraft:entity.item.break player @s
clear @s disabletrial:diamond_spawner_key[damage=10] 1