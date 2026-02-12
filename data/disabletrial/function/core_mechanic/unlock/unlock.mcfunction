scoreboard players set @s dt.success 0
execute store success score @s dt.success as @n[type=marker, tag=dt, limit=1, sort=nearest, distance=0..0.000001] run function disabletrial:core_mechanic/unlock/unlock_marker
execute unless score @s dt.success matches 1 if score @s dt.nomessage matches 0 run tellraw @s {"color":"red","fallback":"Something in the process of unlocking the spawner failed. (the resource pack also didn't load)","translate":"message.chat.disabletrial.unlock.fail"}
execute if score @s dt.success matches 1 if score @s dt.nomessage matches 0 run tellraw @s {"color":"green","fallback":"The spawner was unlocked and should be ready in about 5 minutes. (the resource pack didn't load, you might want to fix that)","translate":"message.chat.disabletrial.unlock.success"}
execute if score @s dt.success matches 1 run return 1
execute unless score @s dt.success matches 1 run return fail