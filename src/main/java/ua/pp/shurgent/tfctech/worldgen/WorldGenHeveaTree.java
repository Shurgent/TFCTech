package ua.pp.shurgent.tfctech.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import ua.pp.shurgent.tfctech.core.ModBlocks;

import com.bioxx.tfc.Core.TFC_Core;

public class WorldGenHeveaTree extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int xCoord, int yCoord, int zCoord) {

		int i = random.nextInt(7) + 6;

		if (yCoord < 1 || yCoord + i + 1 > 256)
			return false;

		boolean flag = true;
		for (int j = yCoord; j <= yCoord + 1 + i; j++) {
			byte byte0 = 1;

			if (j == yCoord)
				byte0 = 0;

			if (j >= (yCoord + 1 + i) - 2)
				byte0 = 2;

			for (int l = xCoord - byte0; l <= xCoord + byte0 && flag; l++) {
				for (int j1 = zCoord - byte0; j1 <= zCoord + byte0 && flag; j1++) {
					if (j >= 0 && j < 256) {
						Block j2 = world.getBlock(l, j, j1);
						if (!j2.isAir(world, l, j, j1) && !j2.isReplaceable(world, l, j, j1)) {
							flag = false;
						}
					} else {
						flag = false;
					}
				}
			}
		}

		if (!flag)
			return false;

		if (!TFC_Core.isSoil(world.getBlock(xCoord, yCoord - 1, zCoord)) || yCoord >= 256 - i - 1)
			return false;

		for (int k1 = yCoord + (i / 3) - 1; k1 <= yCoord + i - 1; k1++) {
			int k2 = k1 - (yCoord + i);
			int z = i;
			if (i > 20)
				z = 20;
			int x = z / 10 + 1;
			if (k1 - yCoord > i / 2 || k1 - yCoord - (i / 3) + 2 < 3)
				x--;
			if (yCoord + i - k1 < 4)
				x = 1;

			for (int l3 = xCoord - x; l3 <= xCoord + x; l3++) {
				int j4 = l3 - xCoord;
				for (int l4 = zCoord - x; l4 <= zCoord + x; l4++) {
					int i5 = l4 - zCoord;
					if ((Math.abs(j4) != 0 || Math.abs(i5) != 0 && k2 != 0)
							&& (Math.abs(j4) + Math.abs(i5) != x * 2 || k1 - yCoord > i / 2 && k1 - yCoord < (4 * i / 5) || k1 - yCoord - (i / 3) + 2 == 2)
							&& random.nextInt(12) != 0 && world.isAirBlock(l3, k1, l4)) {
						setBlockAndNotifyAdequately(world, l3, k1, l4, ModBlocks.heveaLeaves, 0);
					}
				}
			}
		}
		setBlockAndNotifyAdequately(world, xCoord, yCoord + i, zCoord, ModBlocks.heveaLeaves, 0);
		for (int l1 = 0; l1 < i; l1++) {
			setBlockAndNotifyAdequately(world, xCoord, yCoord + l1, zCoord, ModBlocks.logHeveaNatural, 0);
		}
		return true;
	}

}
