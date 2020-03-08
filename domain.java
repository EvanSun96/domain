//domain
//a simple implement problem, just pay more attention to details is all right

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) return res;

        HashMap<String, Integer> map = new HashMap<>();

        int m = cpdomains.length;
        for (int i = 0; i < m; i++) {
            String[] kvPair = cpdomains[i].split(" ");

            String[] keys = kvPair[1].split("\\.");
            String key = "";
            for (int j = keys.length - 1; j >= 0; j--) {
                if (j != keys.length - 1) {
                    key = "." + key;
                }
                key = keys[j] + key;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + Integer.valueOf(kvPair[0]));
                } else {
                    map.put(key, Integer.valueOf(kvPair[0]));
                }
            }
        }
        //print out all k-v pair of hashmap
        for (String key: map.keySet()) {
            String value = Integer.toString(map.get(key));
            res.add(value + " " + key);
        }
        return res;
    }
}

//q2
//longest subarray of two list
//following code means to get the longest subarray of two lists
//now, let's thinking about DP
class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        //so dp actually means: the longest common suffix of A[:i-1] and B[:j-1], so when we get dp[m][n], it actually means A 和B整体字符串的最长公共后缀。 并不是我们要求的A和B最长公共连续子序列。

        int max = 0;
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] +1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];//why do we have to get the gloabl maximum for whole 2D dp?
                    }
                }//if not the same, then stays 0
            }
        }
        return max; //
    }

}
//q3
//histroy should use hashmap: item-ip
//ipaddressUser should be hashMap: ip-id
//purchased userId should be a hashset
