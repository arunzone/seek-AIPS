package au.com.seek.aips.report;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

@Generated
@EqualsAndHashCode
@AllArgsConstructor
@Data
public class TotalVehicleByDate {
  private final LocalDate date;
  private final Long count;
}
