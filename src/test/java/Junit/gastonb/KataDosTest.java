package junit.gastonb;


import org.junit.Test;

import static org.junit.Assert.*;

public class KataDosTest {

    @Test
    public void test1() {
        assertEquals("HELLO WORLD", KataDos.toAlternativeString("hello world"));
    }
    public void test2() {
            assertEquals("hello world", KataDos.toAlternativeString("HELLO WORLD"));
    }
    public void test3() {
        assertEquals("HELLO world", KataDos.toAlternativeString("hello WORLD"));
    }
    public void test4() {
        assertEquals("hEllO wOrld", KataDos.toAlternativeString("HeLLo WoRLD"));
    }
    public void test5() {
        assertEquals("Hello World", KataDos.toAlternativeString(KataDos.toAlternativeString("Hello World")));
    }
    public void test6() {
        assertEquals("12345", KataDos.toAlternativeString("12345"));
    }
    public void test7() {
        assertEquals("1A2B3C4D5E", KataDos.toAlternativeString("1a2b3c4d5e"));
    }
    public void test8() {
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", KataDos.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", KataDos.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", KataDos.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", KataDos.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", KataDos.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}
