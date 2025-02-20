class Solution {
public:
    bool checkRecord(string s) {
        int countAbs = 0;
        int countLate = 0;
       for(int i=0;i<s.length();i++){
        if(s[i]=='A'){
            countAbs++;
            if(countAbs>=2){
                return false;
            }
        }
        if(s[i]=='L'){
            countLate++;
            if(countLate>2){
                return false;
            }
        }else{
            countLate=0;
        }
       }
       return true;
    }
    
};