package net.hyper_pigeon.better_wandering_trader;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public String getModId() {
        return "better_wandering_trader";
    }



   @Override
   public ConfigScreenFactory<?> getModConfigScreenFactory() {
       return screen -> (Screen) AutoConfig.getConfigScreen(BetterWanderingTraderConfig.class, screen).get();
   }

}