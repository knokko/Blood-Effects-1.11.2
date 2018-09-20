package nl.knokko.blood;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = BloodEffects.MODID, name = BloodEffects.NAME, version = BloodEffects.VERSION)
public class BloodEffects
{
    public static final String MODID = "bloodeffects";
    public static final String NAME = "Blood Effects";
    public static final String VERSION = "1.11.2.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event){
    	EntityLivingBase e = event.getEntityLiving();
    	e.world.spawnParticle(EnumParticleTypes.DRIP_WATER, e.posX, e.posY + 1, e.posZ, 0, 0.1, 0);
    	System.out.println(e.world.isRemote);
    }
}
