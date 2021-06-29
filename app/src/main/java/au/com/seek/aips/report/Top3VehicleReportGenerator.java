package au.com.seek.aips.report;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import au.com.seek.aips.entity.VehicleTraffic;

class Top3VehicleReportGenerator {
  private static final Comparator<VehicleTraffic> COMPARE_BY_COUNT = (traffic1, traffic2) -> traffic2.getCount().compareTo(traffic1.getCount());

  List<VehicleTraffic> findTopMost3CountFrom(List<VehicleTraffic> vehicles) {
    return vehicles.stream().sorted(COMPARE_BY_COUNT).limit(3L).collect(Collectors.toList());
  }
}
