#adding damage to the item via this very large item modifier (~900 lines)
execute if score @s dt.hand matches 1 run item modify entity @s weapon.mainhand disabletrial:mainhand/damage_predicate40
execute if score @s dt.hand matches 2 run item modify entity @s weapon.offhand disabletrial:offhand/damage_predicate40
#break item if needed
execute unless predicate disabletrial:40broken run return 1
playsound minecraft:entity.item.break player @s
clear @s minecraft:trial_key[damage=40,custom_data={custom_id:"disabletrial:key",dt_key_level:"netherite"}] 1