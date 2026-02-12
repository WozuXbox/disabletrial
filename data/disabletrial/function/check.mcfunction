execute unless block ~ ~ ~ minecraft:trial_spawner run return 1
execute if entity @e[type=marker,distance=..0.001,tag=!test,tag=dt,tag=dt.marker] run return 2
execute unless block ~ ~ ~ minecraft:trial_spawner[trial_spawner_state=cooldown] run return 3
execute if block ~ ~ ~ minecraft:trial_spawner[ominous=false] run return 4
return 100