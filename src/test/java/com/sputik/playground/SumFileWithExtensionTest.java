package com.sputik.playground;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SumFileWithExtensionTest {

  @Test
  @Disabled("Can not be run by Jenkins")
  void test() throws IOException {
    String path = "C:\\Program Files\\EPAM";
    HashMap<String, Integer> map = new HashMap<>();

    List<Path> paths = Files.walk(Paths.get(path))
        .filter(Files::isReadable)
        .filter(Files::isRegularFile).collect(Collectors.toList());

    paths.forEach(p -> {
      String ext = FileUtils.getExtension(p.getFileName().toString());
      if (map.containsKey(ext)) {
        map.put(ext, map.get(ext) + 1);
      } else {
        map.put(ext, 1);
      }
    });

    map.forEach((key, value) -> System.out.println(key + ": " + value));
    int sum = map.values().stream().mapToInt(Integer::intValue).sum();
    System.out.println("Total files: " + sum);

    assertThat(sum).isEqualTo(159);
  }
}