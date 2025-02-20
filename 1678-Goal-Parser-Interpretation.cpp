class Solution {
public:
    string interpret(string command) {
        string concat; // Correct declaration of string
        int i = command.size() - 1; // Initialize i with the correct size
        while (i >= 0) {
            if (command[i] == 'G') { // Use single quotes for char comparison
                concat.push_back('G');
                i--;
            }
            else if (i > 0 && command[i - 1] == '(' && command[i] == ')') {
                concat.push_back('o');
                i -= 2;
            } else {
                concat.append("la");
                i -= 4; // Subtract 4 because "al" starts from "a"
            }
        }
        reverse(concat.begin(), concat.end()); // Reverse the string to correct the order
        return concat;
    }
};