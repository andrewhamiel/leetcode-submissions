class Solution {
    public String validIPAddress(String queryIP) {
        //case 1: [[0-9]
        //case 2: |[1-9][0-9]
        //case 3: |1[0-9][0-9]
        //case 4: |2[0-4][0-9]
        //case 5: |25[0-5]
        String ipV4 = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String ipV6 = "((([0-9a-fA-F]){1,4})\\:){7}(([0-9a-fA-F]){1,4})";
        if(queryIP.matches(ipV4)) return "IPv4";
        else if(queryIP.matches(ipV6)) return "IPv6";
        else return "Neither";
    }
}