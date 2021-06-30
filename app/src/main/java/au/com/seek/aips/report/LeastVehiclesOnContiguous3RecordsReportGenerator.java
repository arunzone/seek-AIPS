package au.com.seek.aips.report;

import static java.util.Map.Entry.comparingByKey;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import au.com.seek.aips.entity.VehicleTraffic;

public class LeastVehiclesOnContiguous3RecordsReportGenerator {

  public List<VehicleTraffic> findLeastTrafficOn3Contiguous(List<VehicleTraffic> vehicles) {
    Stream<SimpleEntry<Long, List<VehicleTraffic>>> contiguousSumEntries = IntStream.range(0, vehicles.size())
        .filter(index -> vehicles.size() > index + 2)
        .mapToObj(index -> sumTrafficListEntryFrom(vehicles, index));
    return contiguousSumEntries
        .sorted(comparingByKey())
        .limit(1L)
        .map(SimpleEntry::getValue)
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  private SimpleEntry<Long, List<VehicleTraffic>> sumTrafficListEntryFrom(List<VehicleTraffic> vehicles, int index) {
    VehicleTraffic firstTraffic = vehicles.get(index);
    VehicleTraffic secondTraffic = vehicles.get(index + 1);
    VehicleTraffic thirdTraffic = vehicles.get(index + 2);
    long sum = firstTraffic.getCount() + secondTraffic.getCount() + thirdTraffic.getCount();
    return new SimpleEntry<>(sum, List.of(firstTraffic, secondTraffic, thirdTraffic));
  }

}
