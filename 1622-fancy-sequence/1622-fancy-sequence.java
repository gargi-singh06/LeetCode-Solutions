import java.util.*;
class Fancy {
    private static final int MOD = 1_000_000_007;
    private List<Long> arr;
    private long mul;
    private long add;
    public Fancy() {
        arr = new ArrayList<>();
        mul = 1;
        add = 0;
    }
    public void append(int val) {
        long x = (val - add) % MOD;
        if (x < 0) x += MOD;
        x = (x * modInverse(mul)) % MOD;
        arr.add(x);
    }
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        long val = arr.get(idx);
        return (int)((val * mul + add) % MOD);
    }
    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}