package au.com.seek.aips.entity;

import java.time.LocalDateTime;

public class VehicleTraffic {
  private LocalDateTime timestamp;
  private Long count;

  public VehicleTraffic(LocalDateTime timestamp, Long count) {
    this.timestamp = timestamp;
    this.count = count;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public Long getCount() {
    return count;
  }

}
