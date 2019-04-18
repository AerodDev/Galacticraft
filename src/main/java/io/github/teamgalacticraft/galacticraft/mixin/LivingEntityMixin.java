package io.github.teamgalacticraft.galacticraft.mixin;

import alexiil.mc.lib.attributes.item.impl.SimpleFixedItemInv;
import io.github.teamgalacticraft.galacticraft.accessor.GCPlayerAccessor;
import io.github.teamgalacticraft.galacticraft.api.world.dimension.SpaceDimension;
import io.github.teamgalacticraft.galacticraft.entity.damage.GalacticraftDamageSource;
import io.github.teamgalacticraft.galacticraft.items.OxygenTankItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    private int air;

    @Inject(method = "baseTick", at = @At("HEAD"))
    private void baseTick(CallbackInfo ci) {
        air =  ((LivingEntity)(Object)this).getBreath();
    }

    @Inject(method = "baseTick", at = @At("RETURN"))
    private void oxygenDamage(CallbackInfo ci) {
        Entity entity = (LivingEntity)(Object)this;
        if (entity.isAlive()) {
            if (entity.world.dimension instanceof SpaceDimension) {
                if (!((SpaceDimension) entity.world.dimension).hasOxygen()) {
                    entity.setBreath(air - 1);
                    if (entity.getBreath() == -20) {
                        entity.setBreath(0);
                        air = 0;
                        SimpleFixedItemInv gearInventory = ((GCPlayerAccessor) entity).getGearInventory();
                        if (gearInventory.getInvStack(6).getItem() instanceof OxygenTankItem && ((gearInventory.getInvStack(6).getDurability() - gearInventory.getInvStack(6).getDamage()) > 0)) {
                            gearInventory.getInvStack(6).setDamage(gearInventory.getInvStack(6).getDamage() + 1);
                            return;
                        } else if (gearInventory.getInvStack(7).getItem() instanceof OxygenTankItem && ((gearInventory.getInvStack(7).getDurability() - gearInventory.getInvStack(7).getDamage()) > 0)) {
                            gearInventory.getInvStack(7).setDamage(gearInventory.getInvStack(7).getDamage() + 1);
                            return;
                        }
                        entity.damage(GalacticraftDamageSource.SUFFOCATION, 2.0F);
                    }
                }
            }
        }
    }
}
