execute store result score @s dt.hand run function disabletrial:get_hand
execute unless score @s dt.hand matches 1.. run return fail
execute if score @s dt.hand matches 1 run item modify entity @s weapon.mainhand disabletrial:mainhand/replace
execute if score @s dt.hand matches 2 run item modify entity @s weapon.offhand disabletrial:offhand/replace
return 1