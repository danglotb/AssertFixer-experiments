// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-11 16:35:05 -0500
package jnr.constants.platform;
public enum Shutdown implements jnr.constants.Constant {
SHUT_RD,
SHUT_WR,
SHUT_RDWR,
__UNKNOWN_CONSTANT__;
private static final ConstantResolver<Shutdown> resolver = 
ConstantResolver.getBitmaskResolver(Shutdown.class);
public final int intValue() { return (int) resolver.longValue(this); }
public final long longValue() { return resolver.longValue(this); }
public final String description() { return resolver.description(this); }
public final boolean defined() { return resolver.defined(this); }
public final String toString() { return description(); }
public static Shutdown valueOf(long value) { 
    return resolver.valueOf(value);
}
}
