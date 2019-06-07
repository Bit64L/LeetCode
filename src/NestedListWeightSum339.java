import common.NestedInteger;

import java.util.List;

public class NestedListWeightSum339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    public int dfs(List<NestedInteger> list, Integer depth){

        int res = 0;
        for(NestedInteger ni : list){
            if(ni.isInteger()){
                res += ni.getInteger() * depth;
            }else{
                res += dfs(ni.getList(), depth + 1);
            }
        }
        return res;
    }
}
