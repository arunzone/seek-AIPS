package au.com.seek.aips.ui;

import java.time.format.DateTimeFormatter;
import java.util.List;

import au.com.seek.aips.entity.VehicleTraffic;
import au.com.seek.aips.report.LeastVehiclesOnContiguous3RecordsReportGenerator;

public class LeastVehiclesOn3ContiguousRecords {


  private final LeastVehiclesOnContiguous3RecordsReportGenerator top3VehicleReportGenerator;

  public LeastVehiclesOn3ContiguousRecords(LeastVehiclesOnContiguous3RecordsReportGenerator top3VehicleReportGenerator) {
    this.top3VehicleReportGenerator = top3VehicleReportGenerator;
  }

  public void display(List<VehicleTraffic> vehicles) {
    System.out.println("\nLeast traffic 3 contiguous records");
    List<VehicleTraffic> topMost3Traffics = top3VehicleReportGenerator.findLeastTrafficOn3Contiguous(vehicles);
    topMost3Traffics.forEach(vehicle -> {
      String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(vehicle.getTimestamp());
      System.out.printf("%s %d%n", date, vehicle.getCount());
    });
  }
}
