package com.vishrosh.tileengine.world.utils;

import com.badlogic.gdx.math.Vector2;
import com.vishrosh.tileengine.world.Chunk;

public class ChunkUtils {
	
	public static Vector2 mapWorldPosToChunkPos(Vector2 worldPos) {
		Vector2 chunkPos = new Vector2(0, 0);
		chunkPos.x = (int)((worldPos.x + 8)/(16*16))-1;
		chunkPos.y = (int)((worldPos.y + 8)/(16*16))-1;
		return chunkPos;
	}
	
	/**
	 * 
	 * Converts the given chunk position to world coordinates
	 * 
	 * @param chunkPos
	 * @return world position
	 */
	public static Vector2 mapChunkPosToWorldPos(Vector2 chunkPos) {
		Vector2 worldCoords = new Vector2(0, 0);
		worldCoords.x = 16*Chunk.CHUNK_SIZE*(1+chunkPos.x) - 8;
		worldCoords.y = 16*Chunk.CHUNK_SIZE*(1+chunkPos.y) - 8;
		return worldCoords;
	}
	
}
