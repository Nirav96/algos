package strings.hash;
public class RollingHash {
    private static final int MOD = (int)1e9+7;
    private static final int BASE = 31;

    private static int modAdd(int a, int b, int mod){
        int sum = ((a % mod) + (b % mod)) % mod;

        if(sum < 0) sum += mod;

        return sum;
    }

    private static int modMul(int a, int b, int mod){
        int sum = ((a % mod) * (b % mod)) % mod;

        if(sum < 0) sum += mod;

        return sum;
    }

    public static int getHashLower(String str){
        return getHash(str, 'a');
    }

    public static int getHashUpper(String str){
        return getHash(str, 'A');
    }

    private static int getHash(String str, char startingChar){
        int hash = 0;
        int base = 1;

        for(int i = 0; i < str.length(); i++){
            hash = modAdd(hash , modMul(str.charAt(i) - startingChar, base, MOD), MOD);
            base = modMul(base, BASE, MOD);
        }

        return hash;
    }

    public static void main(String[] args) {
        System.out.println(getHashLower("nirav"));
        System.out.println(getHashUpper("NIRAV"));
    }
}
