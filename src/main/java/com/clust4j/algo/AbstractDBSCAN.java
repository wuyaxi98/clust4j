/*******************************************************************************
 *    Copyright 2015, 2016 Taylor G Smith
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *******************************************************************************/
package com.clust4j.algo;

import org.apache.commons.math3.linear.AbstractRealMatrix;

import com.clust4j.algo.preprocess.FeatureNormalization;

abstract class AbstractDBSCAN extends AbstractDensityClusterer implements NoiseyClusterer {
	private static final long serialVersionUID = 5247910788105653778L;
	
	final public static double DEF_EPS = 0.5;
	final public static int DEF_MIN_PTS = 5;

	final protected int minPts;
	protected double eps = DEF_EPS;
	final protected FeatureNormalization normer;

	public AbstractDBSCAN(AbstractRealMatrix data, AbstractDBSCANPlanner planner) {
		super(data, planner);
		
		this.minPts = planner.getMinPts();
		this.normer = planner.getNormalizer();
		
		if(this.minPts < 1)
			throw new IllegalArgumentException("minPts must be greater than 0");
	}
	
	abstract public static class AbstractDBSCANPlanner 
			extends AbstractClusterer.BaseClustererPlanner 
			implements UnsupervisedClassifierPlanner {
		private static final long serialVersionUID = 765572960123009344L;
		
		abstract public AbstractDBSCANPlanner setMinPts(final int minPts);
		abstract public int getMinPts();
	}
	
	public int getMinPts() {
		return minPts;
	}
}