/*
 * This file is part of ELKI:
 * Environment for Developing KDD-Applications Supported by Index-Structures
 *
 * Copyright (C) 2017
 * ELKI Development Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.lmu.ifi.dbs.elki.algorithm.clustering.em;

import de.lmu.ifi.dbs.elki.data.NumberVector;
import de.lmu.ifi.dbs.elki.data.model.MeanModel;

/**
 * Models useable in EM clustering.
 * 
 * @author Erich Schubert
 * @since 0.3
 */
public interface EMClusterModel<M extends MeanModel> {
  /**
   * Begin the E step.
   */
  void beginEStep();

  /**
   * Update the
   * 
   * @param vec Vector to process
   * @param weight Weight of point ("responsibility" of the cluster)
   */
  void updateE(NumberVector vec, double weight);

  /**
   * Finalize the E step.
   * 
   * @param Weight of the cluster
   * @param prior MAP prior (0 for MLE)
   */
  void finalizeEStep(double weight, double prior);

  /**
   * Estimate the log likelihood of a vector.
   * 
   * @param vec Vector
   * @return log likelihood.
   */
  double estimateLogDensity(NumberVector vec);

  /**
   * Finalize a cluster model.
   * 
   * @return Cluster model
   */
  M finalizeCluster();  

  /**
   * Get the cluster weight.
   * 
   * @return Cluster weight
   */
  double getWeight();

  /**
   * Set the cluster weight.
   * 
   * @param weight Cluster weight
   */
  void setWeight(double weight);
}