class Solution {
public:
    vector<vector<int> > result;
    vector<int> temp;
    void put(vector<int> &S,int loc,int lastChoose,int limit)
    {
        if (loc==limit)
        {
            result.push_back(temp);
            return;
        }
        for (int i=lastChoose+1;i<S.size();i++)
        {
            temp.push_back(S[i]);
            put(S,loc+1,i,limit);
            temp.remove(temp.back());
        }
    }
    vector<vector<int> > subsets(vector<int> &S) {
    result.clear();
    temp.clear();
    sort(S.begin(),S.end());
    for(int length=0;length<=S.size();length++)
    {
        put(S,0,-1,length);
    }
    return result;
    }
};