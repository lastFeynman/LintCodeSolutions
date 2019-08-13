package medium;

public class Solution74 {
    public int findFirstBadVersion(int n) {
        if(SVNRepo.isBadVersion(1))
            return 1;
        int start = 1;
        int end = n;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(!SVNRepo.isBadVersion(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    // StackOverFlow
//    public int find(int p, int r){
//        if(p == r)
//            return p;
//        if(r-p == 1)
//            if(SVNRepo.isBadVersion(p))
//                return p;
//            else
//                return r;
//
//        int mid = (p + r) / 2;
//        boolean midV = SVNRepo.isBadVersion(mid);
//        if(midV && (mid-1 < p || !SVNRepo.isBadVersion(mid-1)))
//            return mid;
//        else if(!midV)
//            return find(mid+1, r);
//        else
//            return find(p, mid-1);
//    }

    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        System.out.println(solution74.findFirstBadVersion(2147483647));
    }
}

class SVNRepo{
    static boolean isBadVersion(int n){
        if(n<2147483647)
            return false;
        return true;
    }
}
