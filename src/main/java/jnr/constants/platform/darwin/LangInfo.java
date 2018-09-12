// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-11 20:18:37 -0500
package jnr.constants.platform.darwin;
public enum LangInfo implements jnr.constants.Constant {
CODESET(0L),
D_T_FMT(1L),
D_FMT(2L),
T_FMT(3L),
DAY_1(7L),
DAY_2(8L),
DAY_3(9L),
DAY_4(10L),
DAY_5(11L),
DAY_6(12L),
DAY_7(13L),
ABDAY_1(14L),
ABDAY_2(15L),
ABDAY_3(16L),
ABDAY_4(17L),
ABDAY_5(18L),
ABDAY_6(19L),
ABDAY_7(20L),
MON_1(21L),
MON_2(22L),
MON_3(23L),
MON_4(24L),
MON_5(25L),
MON_6(26L),
MON_7(27L),
MON_8(28L),
MON_9(29L),
MON_10(30L),
MON_11(31L),
MON_12(32L),
ABMON_1(33L),
ABMON_2(34L),
ABMON_3(35L),
ABMON_4(36L),
ABMON_5(37L),
ABMON_6(38L),
ABMON_7(39L),
ABMON_8(40L),
ABMON_9(41L),
ABMON_10(42L),
ABMON_11(43L),
ABMON_12(44L),
RADIXCHAR(50L),
THOUSEP(51L),
YESEXPR(52L),
NOEXPR(53L),
CRNCYSTR(56L);
private final long value;
private LangInfo(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 56L;

static final class StringTable {
  public static final java.util.Map<LangInfo, String> descriptions = generateTable();
  public static final java.util.Map<LangInfo, String> generateTable() {
    java.util.Map<LangInfo, String> map = new java.util.EnumMap<LangInfo, String>(LangInfo.class);
  map.put(CODESET, "CODESET");
  map.put(D_T_FMT, "D_T_FMT");
  map.put(D_FMT, "D_FMT");
  map.put(T_FMT, "T_FMT");
  map.put(DAY_1, "DAY_1");
  map.put(DAY_2, "DAY_2");
  map.put(DAY_3, "DAY_3");
  map.put(DAY_4, "DAY_4");
  map.put(DAY_5, "DAY_5");
  map.put(DAY_6, "DAY_6");
  map.put(DAY_7, "DAY_7");
  map.put(ABDAY_1, "ABDAY_1");
  map.put(ABDAY_2, "ABDAY_2");
  map.put(ABDAY_3, "ABDAY_3");
  map.put(ABDAY_4, "ABDAY_4");
  map.put(ABDAY_5, "ABDAY_5");
  map.put(ABDAY_6, "ABDAY_6");
  map.put(ABDAY_7, "ABDAY_7");
  map.put(MON_1, "MON_1");
  map.put(MON_2, "MON_2");
  map.put(MON_3, "MON_3");
  map.put(MON_4, "MON_4");
  map.put(MON_5, "MON_5");
  map.put(MON_6, "MON_6");
  map.put(MON_7, "MON_7");
  map.put(MON_8, "MON_8");
  map.put(MON_9, "MON_9");
  map.put(MON_10, "MON_10");
  map.put(MON_11, "MON_11");
  map.put(MON_12, "MON_12");
  map.put(ABMON_1, "ABMON_1");
  map.put(ABMON_2, "ABMON_2");
  map.put(ABMON_3, "ABMON_3");
  map.put(ABMON_4, "ABMON_4");
  map.put(ABMON_5, "ABMON_5");
  map.put(ABMON_6, "ABMON_6");
  map.put(ABMON_7, "ABMON_7");
  map.put(ABMON_8, "ABMON_8");
  map.put(ABMON_9, "ABMON_9");
  map.put(ABMON_10, "ABMON_10");
  map.put(ABMON_11, "ABMON_11");
  map.put(ABMON_12, "ABMON_12");
  map.put(RADIXCHAR, "RADIXCHAR");
  map.put(THOUSEP, "THOUSEP");
  map.put(YESEXPR, "YESEXPR");
  map.put(NOEXPR, "NOEXPR");
  map.put(CRNCYSTR, "CRNCYSTR");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
