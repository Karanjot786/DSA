//This is from leetcode
//Unique Email Address
//Question:


/* Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.

 

Example 1:

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.

 */





class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        int count=0;
        for(String email: emails){
            int atIndex = email.indexOf("@");
            int plusIndex= email.indexOf("+");
            String str1 = "";
            if(plusIndex>=0) str1 = email.substring(0,plusIndex);
            else str1 = email.substring(0,atIndex);
            str1 = str1.replace(".","") + email.substring(atIndex);
            if(set.add(str1)) count++;
        }
        return count;
    }
}