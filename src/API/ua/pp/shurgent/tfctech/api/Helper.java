package ua.pp.shurgent.tfctech.api;

import net.minecraftforge.common.util.ForgeDirection;

public class Helper {
	
	public static final ForgeDirection HORIZONTAL_ROTATION_MATRIX[][] = {
			{
					ForgeDirection.DOWN,
					ForgeDirection.UP,
					ForgeDirection.NORTH,
					ForgeDirection.SOUTH,
					ForgeDirection.WEST,
					ForgeDirection.EAST
			},
			{
					ForgeDirection.DOWN,
					ForgeDirection.UP,
					ForgeDirection.EAST,
					ForgeDirection.WEST,
					ForgeDirection.NORTH,
					ForgeDirection.SOUTH
			},
			{
					ForgeDirection.DOWN,
					ForgeDirection.UP,
					ForgeDirection.SOUTH,
					ForgeDirection.NORTH,
					ForgeDirection.EAST,
					ForgeDirection.WEST
			},
			{
					ForgeDirection.DOWN,
					ForgeDirection.UP,
					ForgeDirection.WEST,
					ForgeDirection.EAST,
					ForgeDirection.SOUTH,
					ForgeDirection.NORTH
			}
	};
	
	public static ForgeDirection rotatedSide(int rotation, int side) {
		if (rotation >= 0 && rotation <= 3 && side >= 0 && side < ForgeDirection.VALID_DIRECTIONS.length) {
			return HORIZONTAL_ROTATION_MATRIX[rotation][side];
		}
		return ForgeDirection.UNKNOWN;
	}
	
	public static ForgeDirection rotatedSide(int rotation, Sides side) {
		return rotatedSide(rotation, side.ordinal());
	}
}
