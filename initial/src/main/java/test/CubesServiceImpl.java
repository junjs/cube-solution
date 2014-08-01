package test;

import static java.lang.Math.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("cubesService")
public class CubesServiceImpl implements CubesService {
	private static final Logger logger = Logger.getLogger(CubesServiceImpl.class);

	@Override
	public float getSharedVolume(Cube cube1, Cube cube2) {
		return max(min(cube1.getMaxCoordinates().getX(),cube2.getMaxCoordinates().getX())-max(cube1.getMinCoordinates().getX(),cube2.getMinCoordinates().getX()),0)
		* max(min(cube1.getMaxCoordinates().getY(),cube2.getMaxCoordinates().getY())-max(cube1.getMinCoordinates().getY(),cube2.getMinCoordinates().getY()),0)
		* max(min(cube1.getMaxCoordinates().getZ(),cube2.getMaxCoordinates().getZ())-max(cube1.getMinCoordinates().getZ(),cube2.getMinCoordinates().getZ()),0);
	}

	@Override
	public boolean areIntersected(Cube cube1, Cube cube2) {
		
		logger.info("cube1:" + cube1.getMaxCoordinates().getX() + "," + cube1.getMaxCoordinates().getY() + "," + cube1.getMaxCoordinates().getZ());
		logger.info("cube1:" + cube1.getMinCoordinates().getX() + "," + cube1.getMinCoordinates().getY() + "," + cube1.getMinCoordinates().getZ());
		logger.info("cube2:" + cube2.getMaxCoordinates().getX() + "," + cube2.getMaxCoordinates().getY() + "," + cube2.getMaxCoordinates().getZ());
		logger.info("cube2:" + cube2.getMinCoordinates().getX() + "," + cube2.getMinCoordinates().getY() + "," + cube2.getMinCoordinates().getZ());
		
		 return (cube1.getMaxCoordinates().getX() >= cube2.getMinCoordinates().getX() && cube1.getMinCoordinates().getX() <= cube2.getMaxCoordinates().getX())
				 && (cube1.getMaxCoordinates().getY()  >= cube2.getMinCoordinates().getY() && cube1.getMinCoordinates().getY() <= cube2.getMaxCoordinates().getY() )
			     && (cube1.getMaxCoordinates().getZ()  >= cube2.getMinCoordinates().getZ() && cube1.getMinCoordinates().getZ() <= cube2.getMaxCoordinates().getZ()) ;
	}

}
