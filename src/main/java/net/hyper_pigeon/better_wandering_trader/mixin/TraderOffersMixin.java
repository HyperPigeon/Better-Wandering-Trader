package net.hyper_pigeon.better_wandering_trader.mixin;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;


@Mixin(TradeOffers.class)
public class TraderOffersMixin {

    @Final
    @Mutable
    @Shadow
    public static final Int2ObjectMap<TradeOffers.Factory[]> WANDERING_TRADER_TRADES;

    static class SellItemFactory implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int price;
        private final int count;
        private final int maxUses;
        private final int experience;
        private final float multiplier;

        public SellItemFactory(Block block, int i, int j, int k, int l) {
            this(new ItemStack(block), i, j, k, l);
        }

        public SellItemFactory(Item item, int i, int j, int k) {
            this((ItemStack)(new ItemStack(item)), i, j, 12, k);
        }

        public SellItemFactory(Item item, int i, int j, int k, int l) {
            this(new ItemStack(item), i, j, k, l);
        }

        public SellItemFactory(ItemStack itemStack, int i, int j, int k, int l) {
            this(itemStack, i, j, k, l, 0.05F);
        }

        public SellItemFactory(ItemStack itemStack, int price, int count, int maxUses, int experience, float multiplier) {
            this.sell = itemStack;
            this.price = price;
            this.count = count;
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, this.price), new ItemStack(this.sell.getItem(), this.count), this.maxUses, this.experience, this.multiplier);
        }
    }

    @Shadow private native static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> immutableMap);
    static {

        WANDERING_TRADER_TRADES = copyToFastUtilMap(ImmutableMap.of(1, new TradeOffers.Factory[]{
                new TraderOffersMixin.SellItemFactory(Items.GOLDEN_APPLE, 6, 1, 12,1),
                new TraderOffersMixin.SellItemFactory(Items.FIREWORK_ROCKET, 2, 1, 64,1),
                new TraderOffersMixin.SellItemFactory(Items.ACACIA_SAPLING, 1, 1, 16,1),
                new TraderOffersMixin.SellItemFactory(Items.DARK_OAK_SAPLING, 6, 1, 16,1),
                new TraderOffersMixin.SellItemFactory(Items.NAUTILUS_SHELL, 5, 1, 10,1),
                new TraderOffersMixin.SellItemFactory(Items.PUMPKIN_SEEDS, 1, 1, 16,1),
                new TraderOffersMixin.SellItemFactory(Items.MELON_SEEDS, 1, 1, 16,1),
                new TraderOffersMixin.SellItemFactory(Items.SLIME_BALL, 2, 1, 25,1),
                new TraderOffersMixin.SellItemFactory(Items.HONEY_BOTTLE, 3, 1, 25,1),
                new TraderOffersMixin.SellItemFactory(Items.HAY_BLOCK, 1, 1, 64,1),
                new TraderOffersMixin.SellItemFactory(Items.ZOMBIE_HEAD, 8, 1, 1,1),
                new TraderOffersMixin.SellItemFactory(Items.CREEPER_HEAD, 8, 1, 1,1),
                new TraderOffersMixin.SellItemFactory(Items.SKELETON_SKULL, 8, 1, 1,1),
                new TraderOffersMixin.SellItemFactory(Items.BONE_BLOCK, 2, 1, 20,1),
                new TraderOffersMixin.SellItemFactory(Items.ENDER_PEARL, 6, 1, 16,1),
                new TraderOffersMixin.SellItemFactory(Items.GUNPOWDER, 1, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.SEA_PICKLE, 2, 1, 12,1),
                new TraderOffersMixin.SellItemFactory(Items.PODZOL, 3, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.MYCELIUM, 3, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.BLAZE_ROD, 5, 1, 12,1),
                new TraderOffersMixin.SellItemFactory(Items.CACTUS, 1, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.BRAIN_CORAL_BLOCK, 3, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.BUBBLE_CORAL_BLOCK, 3, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.FIRE_CORAL_BLOCK, 3, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.HORN_CORAL_BLOCK, 3, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.TUBE_CORAL_BLOCK, 3, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.PACKED_ICE, 3, 1, 64,1),
                new TraderOffersMixin.SellItemFactory(Items.BLUE_ICE, 3, 1, 64,1),
                new TraderOffersMixin.SellItemFactory(Items.PUFFERFISH_BUCKET, 4, 1, 8,1),
                new TraderOffersMixin.SellItemFactory(Items.TROPICAL_FISH_BUCKET, 4, 1, 8,1),
                new TraderOffersMixin.SellItemFactory(Items.SWEET_BERRIES, 2, 1, 16,1),
                new TraderOffersMixin.SellItemFactory(Items.BAMBOO, 2, 1, 32,1),
                new TraderOffersMixin.SellItemFactory(Items.TERRACOTTA, 1, 1, 64,1),
                new TraderOffersMixin.SellItemFactory(Items.PRISMARINE_SHARD, 4, 1, 28,1)}, 2,
                new TradeOffers.Factory[]{new TraderOffersMixin.SellItemFactory(Items.ENCHANTED_GOLDEN_APPLE, 56, 1, 1,1),
                        new TraderOffersMixin.SellItemFactory(Items.TOTEM_OF_UNDYING,  56, 1, 1,1),
                        new TraderOffersMixin.SellItemFactory(Items.WITHER_SKELETON_SKULL, 64, 1, 1,1),
                        new TraderOffersMixin.SellItemFactory(Items.TRIDENT, 25, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.GHAST_TEAR, 12, 1, 4,1),
                        new TraderOffersMixin.SellItemFactory(Items.HEART_OF_THE_SEA, 56, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.DRAGON_BREATH, 32, 1, 3,1),
                        new TraderOffersMixin.SellItemFactory(Items.SHULKER_SHELL, 16, 1, 3,1),
                        new TraderOffersMixin.SellItemFactory(Items.ENDER_EYE, 16, 1, 3,1),
                        new TraderOffersMixin.SellItemFactory(Items.DIAMOND_HELMET, 16, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.DIAMOND_CHESTPLATE, 16, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.DIAMOND_LEGGINGS, 16, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.DIAMOND_BOOTS, 16, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.DIAMOND_PICKAXE, 16, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.DIAMOND_SWORD, 16, 1, 2,1),
                        new TraderOffersMixin.SellItemFactory(Items.DIAMOND_AXE, 16, 1, 2,1)}));
    }
}
