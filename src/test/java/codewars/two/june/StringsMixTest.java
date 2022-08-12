package codewars.two.june;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsMixTest {

  @Test
  void test() {
    assertEquals("2:eeeee/2:yy/=:hh/=:rr", mix("Are they here", "yes, they are here"));
    assertEquals(
        "1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
        mix("looping is fun but dangerous", "less dangerous than coding"));
    assertEquals(
        "1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
        mix(" In many languages", " there's a pair of functions"));
    assertEquals("1:ee/1:ll/1:oo", mix("Lords of the Fallen", "gamekult"));
    assertEquals("", mix("codewars", "codewars"));
    assertEquals(
        "1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr",
        mix("A generation must confront the looming ", "codewarrs"));
  }

  public String mix(String s1, String s2) {
    Map<String, Integer> charCountMap = countChars(s1);
    Map<String, Integer> charCountMap2 = countChars(s2);

    HashSet<Unit> units = new HashSet<>();
    addToUnitsSet(charCountMap, units, "1:");
    addToUnitsSet(charCountMap2, units, "2:");

    List<Unit> orderedUnits = units.stream().sorted(
        Comparator.comparingInt(
            (Unit o) -> o.count
            ).reversed()
             .thenComparing(o -> o.name)
        ).toList();

    return orderedUnits.stream().map(Unit::name).collect(Collectors.joining("/"));
  }

  private void addToUnitsSet(Map<String, Integer> charCountMap, HashSet<Unit> units, String prefix) {
    charCountMap.entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .forEach(entry -> {
            Unit toAdd = new Unit(prefix, entry.getKey(), entry.getValue());
            if (!units.add(toAdd)) {
              takeLongest(units, toAdd);
            }
        });
  }

  private void takeLongest(HashSet<Unit> set, Unit toAdd) {
    Optional<Unit> cur = set.stream().filter(it -> it.equals(toAdd)).findFirst();
    if (cur.isPresent()) {
      Unit unit = cur.get();
      if (unit.smaller(toAdd)) {
        replaceUnit(set, unit, toAdd);
      } else if (unit.count == toAdd.count) {
        replaceUnit(set, unit, new Unit("=:", unit.letter, unit.count));
      }
    }
  }

  private void replaceUnit(HashSet<Unit> set, Unit curUnit, Unit newUnit) {
    set.remove(curUnit);
    set.add(newUnit);
  }

  public Map<String, Integer> countChars(String str) {
    return Arrays.stream(str.replaceAll("[^a-z]", "").split(""))
        .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));
  }

  class Unit {
    String name;
    String letter;
    int count;

    public Unit(String name, String letter, int count) {
      this.name = name + letter.repeat(count);
      this.letter = letter;
      this.count = count;
    }

    public boolean smaller(Unit u) {
      return this.count < u.count;
    }

    public String name() {
      return this.name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Unit unit = (Unit) o;

      return letter.equals(unit.letter);
    }

    @Override
    public int hashCode() {
      return letter.hashCode();
    }
  }
}
