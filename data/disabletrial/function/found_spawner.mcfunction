scoreboard players enable @s dt.nomessage
scoreboard players set @s dt.warn 0
execute store result score @s dt.warn run function disabletrial:check
scoreboard players set @s dt.success 0
execute if score @s dt.warn matches 1 if score @s dt.nomessage matches 0 run tellraw @s {"color":"red","fallback":"No spawner found, although raycast did. Check for errors. (the resource pack also didn't load or your language is not supported)","translate":"message.chat.disabletrial.check.warn.codefailed"}
execute if score @s dt.warn matches 2 if score @s dt.nomessage matches 0 run tellraw @s {"color":"red","fallback":"Found locked spawner, unlocking... (the resource pack also didn't load or your language is not supported)","translate":"message.chat.disabletrial.check.warn.unlocked"}
execute if score @s dt.warn matches 3 if score @s dt.nomessage matches 0 run tellraw @s {"color":"red","fallback":"This spawner isn't on cooldown. (the resource pack also didn't load or your language is not supported)","translate":"message.chat.disabletrial.check.warn.cooldown"}
execute if score @s dt.warn matches 4 if score @s dt.nomessage matches 0 run tellraw @s {"color":"red","fallback":"This spawner isn't ominous. This is only a warning, as disabled ominous spawners can be reactivated when a player with trial omen is nearby. (the resource pack also didn't load)","translate":"message.chat.disabletrial.check.warn.ominous"}
execute if score @s dt.warn matches 4 run scoreboard players set @s dt.warn 100
execute if score @s dt.warn matches 100 if score @s dt.nomessage matches 0 run tellraw @s {"color":"green","fallback":"Spawner detected, locking...","translate":"message.chat.disabletrial.check.warn.success"}
execute if score @s dt.warn matches 100 store result score @s dt.success run function disabletrial:core_mechanic/summon/summon
execute if score @s dt.warn matches 2 store result score @s dt.success run function disabletrial:core_mechanic/unlock/unlock
function disabletrial:message_tellraw
execute if score @s dt.success matches 1 run return 1
execute if score @s dt.success matches 0 run return fail