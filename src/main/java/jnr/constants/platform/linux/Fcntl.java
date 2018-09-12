// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated Tue Feb 24 09:44:05 +1000 2009
package jnr.constants.platform.linux;
public enum Fcntl implements jnr.constants.Constant {
FAPPEND(1024),
// FREAD not defined
// FWRITE not defined
FASYNC(8192),
FFSYNC(4096),
FNONBLOCK(2048),
FNDELAY(2048),
F_DUPFD(0),
F_GETFD(1),
F_SETFD(2),
F_GETFL(3),
F_SETFL(4),
F_GETOWN(9),
F_SETOWN(8),
F_GETLK(12),
F_SETLK(13),
F_SETLKW(14),
// F_CHKCLEAN not defined
// F_PREALLOCATE not defined
// F_SETSIZE not defined
// F_RDADVISE not defined
// F_RDAHEAD not defined
// F_READBOOTSTRAP not defined
// F_WRITEBOOTSTRAP not defined
// F_NOCACHE not defined
// F_LOG2PHYS not defined
// F_GETPATH not defined
// F_FULLFSYNC not defined
// F_PATHPKG_CHECK not defined
// F_FREEZE_FS not defined
// F_THAW_FS not defined
// F_GLOBAL_NOCACHE not defined
// F_ADDSIGS not defined
// F_MARKDEPENDENCY not defined
F_RDLCK(0),
F_UNLCK(2),
F_WRLCK(1);
// F_ALLOCATECONTIG not defined
// F_ALLOCATEALL not defined
private final int value;
private Fcntl(int value) { this.value = value; }
public static final long MIN_VALUE = 0;
public static final long MAX_VALUE = 8192;

public final int value() { return value; }
public final int intValue() { return value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
