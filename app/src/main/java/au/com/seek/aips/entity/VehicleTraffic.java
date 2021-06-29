package au.com.seek.aips.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;

@Generated
@EqualsAndHashCode
@Data
public class VehicleTraffic {
  private LocalDateTime timestamp;
  private Long count;

  public VehicleTraffic(LocalDateTime timestamp, Long count) {
    this.timestamp = timestamp;
    this.count = count;
  }
}
