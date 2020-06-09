package net.hyper_pigeon.better_wandering_trader.mixin;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.hyper_pigeon.better_wandering_trader.BetterWanderingTraderConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.passive.AbstractTraderEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.item.Item;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TraderOfferList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WanderingTraderEntity.class)
public class WanderingTraderEntityMixin extends AbstractTraderEntity {

    @Shadow
    public native void fillRecipes();

    @Shadow
    public native void afterUsing(TradeOffer offer);

    @Shadow
    public native PassiveEntity createChild(PassiveEntity mate);


    public WanderingTraderEntityMixin(EntityType<? extends AbstractTraderEntity> entityType, World world) {
        super(entityType, world);
    }


   @Inject(at = @At("RETURN"), method = "fillRecipes")
    public void add_new_list(CallbackInfo info) {
        BetterWanderingTraderConfig config = AutoConfig.getConfigHolder(BetterWanderingTraderConfig.class).getConfig();
        if (config.trades.enable_user_added_traded) {
            TradeOffers.Factory[] factorys3 = TradeOffers.WANDERING_TRADER_TRADES.get(3);
            if (factorys3 != null) {
                if (this.getOffers() != null) {
                    TraderOfferList traderOfferList = this.getOffers();
                    //System.out.println("CHECK: " + traderOfferList);
                    //System.out.println("CHECK2: " + factorys3);
                    //System.out.println("CHECK3: " + factorys3[0]);
                    //System.out.println("CHECK2: " + factorys3[0].toString());
                    this.fillRecipesFromPool(traderOfferList, factorys3, config.invisibleTradeFactory.trades_to_choose);
                }
            }
        }
    }





}