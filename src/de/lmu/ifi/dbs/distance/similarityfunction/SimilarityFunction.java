package de.lmu.ifi.dbs.distance.similarityfunction;

import de.lmu.ifi.dbs.data.DatabaseObject;
import de.lmu.ifi.dbs.distance.Distance;
import de.lmu.ifi.dbs.distance.MeasurementFunction;

/**
 * Interface SimilarityFunction describes the requirements of any similarity
 * function.
 *
 * @author Elke Achtert (<a href="mailto:achtert@dbs.ifi.lmu.de">achtert@dbs.ifi.lmu.de</a>)
 */
public interface SimilarityFunction<O extends DatabaseObject, D extends Distance<D>> extends MeasurementFunction<O, D> {

  /**
   * Returns the similarity between the two objcts specified by their obejct ids.
   *
   * @param id1 first object id
   * @param id2 second object id
   * @return the similarity between the two objcts specified by their obejct ids
   */
  D similarity(Integer id1, Integer id2);

  /**
   * Returns the similarity between the two specified objects.
   *
   * @param id1 first object id
   * @param o2  second DatabaseObject
   * @return the similarity between the two objcts specified by their obejct ids
   */
  D similarity(Integer id1, O o2);

  /**
   * Computes the similarity between two given DatabaseObjects according to this
   * similarity function.
   *
   * @param o1 first DatabaseObject
   * @param o2 second DatabaseObject
   * @return the similarity between two given DatabaseObjects according to this
   *         similarity function
   */
  D similarity(O o1, O o2);
}
