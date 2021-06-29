package au.com.seek.aips.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

import java.time.LocalDate;

@Generated
@EqualsAndHashCode
@AllArgsConstructor
@Data
class TotalVehicleByDate {
  private final LocalDate date;
  private final Long count;
}
