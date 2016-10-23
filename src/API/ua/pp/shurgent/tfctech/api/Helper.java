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
	
	public static byte getWrenchingSide(byte side, float x, float y, float z) {
		byte back_side = (byte) ForgeDirection.getOrientation(side).getOpposite().ordinal();
		switch (side) {
		case 0:
		case 1:
			if (x < 0.25) {
				if (z < 0.25)
					return back_side;
				if (z > 0.75)
					return back_side;
				return 4;
			}
			if (x > 0.75) {
				if (z < 0.25)
					return back_side;
				if (z > 0.75)
					return back_side;
				return 5;
			}
			if (z < 0.25)
				return 2;
			if (z > 0.75)
				return 3;
			return side;
		case 2:
		case 3:
			if (x < 0.25) {
				if (y < 0.25)
					return back_side;
				if (y > 0.75)
					return back_side;
				return 4;
			}
			if (x > 0.75) {
				if (y < 0.25)
					return back_side;
				if (y > 0.75)
					return back_side;
				return 5;
			}
			if (y < 0.25)
				return 0;
			if (y > 0.75)
				return 1;
			return side;
		case 4:
		case 5:
			if (z < 0.25) {
				if (y < 0.25)
					return back_side;
				if (y > 0.75)
					return back_side;
				return 2;
			}
			if (z > 0.75) {
				if (y < 0.25)
					return back_side;
				if (y > 0.75)
					return back_side;
				return 3;
			}
			if (y < 0.25)
				return 0;
			if (y > 0.75)
				return 1;
			return side;
		}
		return -1;
	}
}
