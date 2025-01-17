package me.metallicgoat.specialItems.items.silverfish;

import de.marcely.bedwars.api.arena.Team;
import me.metallicgoat.specialItems.Main;
import org.bukkit.entity.Silverfish;
import org.bukkit.scheduler.BukkitRunnable;

public class UpdateDisplayName {

    public void setDisplayName(Team team, Silverfish silverfish){
        final int[] i = {0};
        silverfish.setCustomNameVisible(true);
        String teamName = team.getDisplayName();
        String c = "§" + team.getChatColor().getChar();
        new BukkitRunnable() {
            @Override
            public void run(){
                if(SilverfishThrow.silverfishTeamHashMap.containsKey(silverfish) && !silverfish.isDead()){
                    if(i[0] < 5){
                        if(i[0] == 0){
                            silverfish.setCustomName(c + "§l" + teamName + c + " [■ ■ ■ ■ ■]");
                        }else if(i[0] == 1){
                            silverfish.setCustomName(c + "§l" + teamName + c + " [■ ■ ■ ■ §7■]");
                        }else if(i[0] == 2){
                            silverfish.setCustomName(c + "§l" + teamName + c + " [■ ■ ■ §7■ ■]");
                        }else if(i[0] == 3){
                            silverfish.setCustomName(c + "§l" + teamName + c + " [■ ■ §7■ ■ ■]");
                        }else if(i[0] == 4){
                            silverfish.setCustomName(c + "§l" + teamName + c + " [■ §7■ ■ ■ ■]");
                        }
                    }else{
                        cancel();
                        return;
                    }
                    i[0]++;
                }else{
                    cancel();
                }
            }
        }.runTaskTimer(plugin(), 0L, 80L);
    }


    private static Main plugin(){
        return Main.getInstance();
    }
}
