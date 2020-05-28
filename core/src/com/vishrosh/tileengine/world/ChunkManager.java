package com.vishrosh.tileengine.world;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.GridPoint2;
import com.vishrosh.tileengine.utils.maths.MathUtilities;
import com.vishrosh.tileengine.world.utils.ChunkUtils;

public class ChunkManager {
	
	@SuppressWarnings("unused")
	private GridPoint2 renderDistance;
	List<String> chunksToGen;
	public ChunksGenerator chunkGen;
	

	public ChunkManager() {
		this.renderDistance = new GridPoint2(1, 1);
		this.chunksToGen = new ArrayList<>();
	}
	
	public void setChunkGen(ChunksGenerator chunkGen) {
		this.chunkGen = chunkGen;
	}
	
	/*public void addToChunksToGen() {
		String chunkToGen = MathUtilities.gridPoint2String(new GridPoint2((int)chunkPos.x+, (int)chunkPos.y+j));
		System.out.println(i + ": " + chunkToGen);
		chunksToGen.add(chunkToGen);
		this.chunkGen.loadChunk(chunkToGen);
	}*/
	
	public void addToChunksToGen(String chunk) {
		if(this.chunksToGen.contains(chunk))return;
		this.chunksToGen.add(chunk);
	}
	
	public void loadChunAtPos(GridPoint2 pos) {
		GridPoint2 chunkPos = ChunkUtils.mapWorldPosToChunkPos(pos);
		this.chunkGen.addChunk(chunkPos);
		String chunkPosAsString = MathUtilities.gridPoint2String(chunkPos);
		this.chunkGen.loadChunk(chunkPosAsString);
	}
	
}
