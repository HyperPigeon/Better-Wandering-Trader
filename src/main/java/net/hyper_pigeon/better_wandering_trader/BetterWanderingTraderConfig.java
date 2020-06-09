package net.hyper_pigeon.better_wandering_trader;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import net.hyper_pigeon.better_wandering_trader.mixin.TraderOffersMixin;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;

@Config(name = "better_wandering_trader")
public class BetterWanderingTraderConfig implements ConfigData {


    /*@Comment("Toggle A")
    boolean toggleA = true;

    @Comment("Toggle B")
    boolean toggleB = false;

    @ConfigEntry.Gui.CollapsibleObject
    InnerStuff stuff = new InnerStuff();

    @ConfigEntry.Gui.Excluded
    InnerStuff invisibleStuff = new InnerStuff();


    static class InnerStuff {
        int a = 0;
        int b = 1;
    }*/

    @ConfigEntry.Gui.CollapsibleObject
    public UserAddedTrades trades = new UserAddedTrades();

    public static class UserAddedTrades {
        public boolean enable_user_added_traded = false;
    }

    @ConfigEntry.Gui.Excluded
    public TradeArray invisibleTradeFactory = new TradeArray();

    @ConfigEntry.Gui.Excluded
    TradeFormat example = new TradeFormat();

    public static class TradeArray {
        //TradeOffers.Factory[] new_trades = new TradeOffers.Factory[]{};
        //TradeOffers.Factory example = new TraderOffersMixin.SellItemFactory(Items.TOTEM_OF_UNDYING,  56, 1, 1,1);
        public int number_of_trades = 1;
        public int trades_to_choose = 1;
        public TradeFormat array[] = new TradeFormat[number_of_trades];
    }

    public static class TradeFormat {
        public String identifier = "minecraft:end_crystal";
        public int price = 0;
        public int count = 0;
        public int maxUses = 0;
        public int experience = 0;
    }



}
