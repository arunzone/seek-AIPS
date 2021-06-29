package au.com.seek.aips.report;

import au.com.seek.aips.entity.VehicleTraffic;

import java.util.List;

class TotalReportGenerator {
  Long totalOf(List<VehicleTraffic> vehicles) {
    return vehicles.parallelStream()
        .mapToLong(VehicleTraffic::getCount)
        .sum();
  }
}
