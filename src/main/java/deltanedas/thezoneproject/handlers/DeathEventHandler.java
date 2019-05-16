package deltanedas.thezoneproject.handlers;

import deltanedas.thezoneproject.TheZoneProject;
import deltanedas.thezoneproject.entities.EntityBlindWolf;
import deltanedas.thezoneproject.entities.EntitySnork;
import deltanedas.thezoneproject.init.InitConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DeathEventHandler {
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event) {
		if (event.getSource().damageType.equals("fatal_rads")) {
			Entity e = event.getEntity();
			World worldIn = e.world;
			BlockPos pos = e.getPosition();
			double X = pos.getX();
			double Y = pos.getY();
			double Z = pos.getZ();
			float Pitch = e.rotationPitch;
			float Yaw = e.rotationYaw;
			if (worldIn.rand.nextInt(InitConfig.mobMutateChance) == 1) { // Mob mutated
				if (e instanceof EntityVillager || e instanceof EntityPlayer) {
					if (worldIn.rand.nextInt(InitConfig.bloodsuckerMutateChance) <= 1) {
						//EntityBloodsucker mutant = new EntityBloodsucker(worldIn);
						//mutant.setPositionAndRotation(X, Y, Z, Pitch, Yaw);
						//worldIn.spawnEntity(mutant);
						
					} else if (worldIn.rand.nextInt(InitConfig.snorkMutateChance) <= 1) {
						EntitySnork mutant = new EntitySnork(worldIn);
						mutant.setPositionAndRotation(X, Y, Z, Pitch, Yaw);
						worldIn.spawnEntity(mutant);
					}
				} else if (e instanceof EntityWolf) {
					if (worldIn.rand.nextInt(InitConfig.pseudowolfMutateChance) <= 1) {
						//EntityPseudowolf mutant = new EntityPseudowolf(worldIn);
						//mutant.setPositionAndRotation(X, Y, Z, Pitch, Yaw);
						//worldIn.spawnEntity(mutant);
						
					} else if (worldIn.rand.nextInt(InitConfig.blindWolfMutateChance) <= 1) {
						EntityBlindWolf mutant = new EntityBlindWolf(worldIn);
						mutant.setPositionAndRotation(X, Y, Z, Pitch, Yaw);
						worldIn.spawnEntity(mutant);
					}
				}
			}
		}
	}
}
