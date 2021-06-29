package au.com.seek.aips.report;

import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;

class TotalReportGenerator {
  Long totalOf(List<VehicleTraffic> vehicles) {
    return vehicles.parallelStream()
        .mapToLong(VehicleTraffic::getCount)
        .sum();
  }
}
