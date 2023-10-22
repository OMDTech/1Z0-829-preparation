package org.enricogiurin.ocp17.ch4.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UseOfDuration {

  public static void main(String[] args) {
    new UseOfDuration().addDurationToDate();
  }

  void between() {
    var now = Instant.now();
    var later = Instant.now();
    System.out.println("instant: " + later); //2023-09-03T19:55:15.400194Z
    var duration = Duration.between(now, later);
    System.out.println("elapsed time: " + duration.toNanos() + "ns");
  }

  void addDurationToDate() {
    Duration d1h = Duration.ofHours(1L);
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now); //2023-10-23T00:57:58.181994
    LocalDateTime then = now.plus(d1h);
    System.out.println(then);  //2023-10-23T01:57:58.181994
  }

  void manipulateDuration() {
    Duration duration = Duration.ofDays(1L);
    System.out.println(duration); //PT24H

    duration = duration.plus(1, ChronoUnit.SECONDS)
        .plus(1, ChronoUnit.MINUTES)
        .plus(1, ChronoUnit.DAYS);
    System.out.println(duration); //PT48H1M1S

    duration = Duration.ofNanos(1000L);
    System.out.println("duration 1k nanos: "+duration);
  }

  void invalidDuration() {
    //Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unit must not have an estimated duration
    Duration oneMonth = Duration.of(1, ChronoUnit.MONTHS);
    System.out.println(oneMonth);
  }


}
