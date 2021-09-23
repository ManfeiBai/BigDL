/*
 * Copyright 2018 Analytics Zoo Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intel.analytics.bigdl.dllib.keras.objectives

import com.intel.analytics.bigdl.dllib.keras.layers.KerasBaseSpec

class MeanSquaredLogarithmicErrorSpec extends KerasBaseSpec{

  "MeanSquaredLogarithmicCriterion" should "be ok" in {
    val kerasCode =
      """
        |input_tensor = Input(shape=[10])
        |target_tensor = Input(shape=[10])
        |loss = mean_squared_logarithmic_error(target_tensor, input_tensor)
        |input = np.random.uniform(-1, 1, [5, 10])
        |Y = np.random.uniform(-1, 1, [5, 10])
      """.stripMargin
    val criterion = msle[Float]()
    checkOutputAndGradForLoss(criterion, kerasCode)
  }

  "MeanSquaredLogarithmicCriterion" should "be ok with epsilon" in {
    val kerasCode =
      """
        |input_tensor = Input(shape=[3])
        |target_tensor = Input(shape=[3])
        |loss = mean_squared_logarithmic_error(target_tensor, input_tensor)
        |input = np.array([[1e-07, 1e-06, 1e-08]])
        |Y = np.array([[1, 2, 3]])
      """.stripMargin
    val criterion = msle[Float]()
    checkOutputAndGradForLoss(criterion, kerasCode)
  }
}