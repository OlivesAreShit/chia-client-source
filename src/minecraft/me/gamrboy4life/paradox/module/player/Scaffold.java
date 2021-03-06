package me.gamrboy4life.paradox.module.player;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Scaffold extends Module {
	
	private static boolean cooldown = false;
    public Scaffold() {
        super("Scaffold", 0, Category.PLAYER);
    }
    
    @Override
    public void onUpdate() {
    	BlockPos playerBlock = new BlockPos(mc.thePlayer.posX, mc.thePlayer.getEntityBoundingBox().minX, mc.thePlayer.posZ);
    	if(mc.theWorld.isAirBlock(playerBlock.add(0, -1, 0))) {
    		if(isValidBlock(playerBlock.add(0, -2, 0))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.UP);
    		}else if(isValidBlock(playerBlock.add(-1, -1, 0))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.EAST);
    		}else if(isValidBlock(playerBlock.add(1, -1, 0))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.WEST);
    		}else if(isValidBlock(playerBlock.add(0, -1, -1))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.SOUTH);
    		}else if(isValidBlock(playerBlock.add(0, -1, -1))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.NORTH);
    			
    		}else if(isValidBlock(playerBlock.add(1, -1, 1))) {
    			if(isValidBlock(playerBlock.add(0, -1, 1))) {
    				place(playerBlock.add(0, -1, 1), EnumFacing.NORTH);
    			}
    			place(playerBlock.add(1, -1, 1), EnumFacing.EAST);
    			
    		}else if(isValidBlock(playerBlock.add(-1, -1, 1))) {
    			if(isValidBlock(playerBlock.add(-1, -1, 0))) {
    				place(playerBlock.add(0, -1, 1), EnumFacing.WEST);
    			}
    			place(playerBlock.add(-1, -1, 1), EnumFacing.SOUTH);
    			
    		}else if(isValidBlock(playerBlock.add(-1, -1, -1))) {
    			if(isValidBlock(playerBlock.add(0, -1, -1))) {
    				place(playerBlock.add(0, -1, -1), EnumFacing.SOUTH);
    			}
    			place(playerBlock.add(-1, -1, 1), EnumFacing.WEST);
    			
    		}else if(isValidBlock(playerBlock.add(1, -1, -1))) {
    			if(isValidBlock(playerBlock.add(1, -1, 0))) {
    				place(playerBlock.add(1, -1, 0), EnumFacing.EAST);
    			}
    			place(playerBlock.add(1, -1, -1), EnumFacing.NORTH);
    		}
    		super.onUpdate();
    	}
    }
    
    private boolean isValidBlock(BlockPos pos) {
    	Block b = mc.theWorld.getBlockState(pos).getBlock();
    	return (!(b instanceof BlockLiquid)) && (b.getMaterial() != Material.air);
    }
    
    private void place(BlockPos pos, EnumFacing face) {
    	cooldown = true;
    	if(face == EnumFacing.UP) {
    		pos = pos.add(0, -1, 0);
    	}else if(face == EnumFacing.NORTH) {
    		pos = pos.add(0, 0, 1);
    	}else if(face == EnumFacing.EAST) {
    		pos = pos.add(-1, 0, 0);
    	}else if(face == EnumFacing.SOUTH) {
    		pos = pos.add(0, 0, -1);
    	}else if(face == EnumFacing.WEST) {
    		pos .add(1, 0, 0);
    	}
    	
    	if((mc.thePlayer.getHeldItem() != null) && ((mc.thePlayer.getHeldItem().getItem() instanceof ItemBlock))) {
    		mc.thePlayer.swingItem();
    		mc.playerController.func_178890_a(mc.thePlayer, mc.theWorld, mc.thePlayer.getHeldItem(), pos, face, new Vec3(0.5D, 0.5D, 0.5D));
    		double var4 = pos.getX() + 0.25D - mc.thePlayer.posX;
    		double var6 = pos.getZ() + 0.25D- mc.thePlayer.posZ;
    		double var8 = pos.getY() + 0.25D- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
    		double var14 = MathHelper.sqrt_double(var4 * var4 * var6 * var6);
    		float yaw = (float)(Math.atan2(var6, var4) * 180.0D / 3.141592653689793D) - 90.0F;
    		float pitch = (float)-(Math.atan2(var8, var14) * 180.0D / 3.141592653689793D);
    		int ticks = 0;
    		ticks++;
    		if(ticks >= 1000) {
    			ticks = 0;
    			mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, yaw, pitch, mc.thePlayer.onGround));
    		}
    	}
    }
    
    @Override
    public void onEnable() {
    	BlockPos playerBlock = new BlockPos(mc.thePlayer.posX, mc.thePlayer.getEntityBoundingBox().minX, mc.thePlayer.posZ);
    	if(mc.theWorld.isAirBlock(playerBlock.add(0, -1, 0))) {
    		if(isValidBlock(playerBlock.add(0, -2, 0))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.UP);
    		}else if(isValidBlock(playerBlock.add(-1, -1, 0))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.EAST);
    		}else if(isValidBlock(playerBlock.add(1, -1, 0))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.WEST);
    		}else if(isValidBlock(playerBlock.add(0, -1, -1))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.SOUTH);
    		}else if(isValidBlock(playerBlock.add(0, -1, -1))) {
    			place(playerBlock.add(0, -1, 0), EnumFacing.NORTH);
    			
    		}else if(isValidBlock(playerBlock.add(1, -1, 1))) {
    			if(isValidBlock(playerBlock.add(0, -1, 1))) {
    				place(playerBlock.add(0, -1, 1), EnumFacing.NORTH);
    			}
    			place(playerBlock.add(1, -1, 1), EnumFacing.EAST);
    			
    		}else if(isValidBlock(playerBlock.add(-1, -1, 1))) {
    			if(isValidBlock(playerBlock.add(-1, -1, 0))) {
    				place(playerBlock.add(0, -1, 1), EnumFacing.WEST);
    			}
    			place(playerBlock.add(-1, -1, 1), EnumFacing.SOUTH);
    			
    		}else if(isValidBlock(playerBlock.add(-1, -1, -1))) {
    			if(isValidBlock(playerBlock.add(0, -1, -1))) {
    				place(playerBlock.add(0, -1, -1), EnumFacing.SOUTH);
    			}
    			place(playerBlock.add(-1, -1, 1), EnumFacing.WEST);
    			
    		}else if(isValidBlock(playerBlock.add(1, -1, -1))) {
    			if(isValidBlock(playerBlock.add(1, -1, 0))) {
    				place(playerBlock.add(1, -1, 0), EnumFacing.EAST);
    			}
    			place(playerBlock.add(1, -1, -1), EnumFacing.NORTH);
    		}
    	}
    	super.onEnable();
    }
    
    @Override
    public void onDisable() {
    	super.onDisable();
    }
}