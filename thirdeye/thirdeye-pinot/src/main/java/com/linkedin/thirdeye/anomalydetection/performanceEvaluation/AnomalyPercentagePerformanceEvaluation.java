/**
 * Copyright (C) 2014-2018 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.linkedin.thirdeye.anomalydetection.performanceEvaluation;

import com.linkedin.thirdeye.datalayer.dto.MergedAnomalyResultDTO;
import com.linkedin.thirdeye.util.IntervalUtils;
import java.util.List;
import org.joda.time.Interval;


/**
 * The performance evaluator calculates the percentage of time when there are anomalies
 * We care about the frequency of anomaly generated by our algorithm. This performance evaluator can help us providing
 * this information to clients or backend algorithms
 */
public class AnomalyPercentagePerformanceEvaluation extends BasePerformanceEvaluate{
  private Interval windowInterval;
  private List<MergedAnomalyResultDTO> detectedResults;

  public AnomalyPercentagePerformanceEvaluation(Interval windowInterval, List<MergedAnomalyResultDTO> detectedResults) {
    this.windowInterval = windowInterval;
    this.detectedResults = detectedResults;
  }

  @Override
  public double evaluate(){
    long anomalyLength = 0;
    long totalLength = windowInterval.toDurationMillis();

    List<Interval> anomalyIntervals = mergedAnomalyResultsToIntervals(detectedResults);
    anomalyIntervals = IntervalUtils.mergeIntervals(anomalyIntervals);

    for(Interval interval : anomalyIntervals) {
      anomalyLength += interval.toDurationMillis();
    }

    double ratio = (double) anomalyLength / totalLength;
    return ratio;
  }
}
